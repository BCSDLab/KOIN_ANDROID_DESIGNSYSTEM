package `in`.koreatech.koin.designsystem.switch

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import `in`.koreatech.koin.designsystem.KoinTheme

@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    disabled: Boolean = false,
    emphasized: Boolean = true,
    switchInteractionColors: SwitchInteractionColors = SwitchDefaults.switchInteractionColors()
) {
    var isChecked by remember(checked) { mutableStateOf(checked) }
    val animateOffset = remember { Animatable(if (isChecked) 1f else 0f) }
    LaunchedEffect(isChecked) {
        animateOffset.animateTo(if (isChecked) 1f else 0f, animationSpec = tween(durationMillis = 300))
    }

    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }

    val switchStateColors = remember(disabled, isPressed, isFocused, isHovered) {
        if (disabled) {
            switchInteractionColors.disabledSwitchStateColors
        } else if (isPressed) {
            switchInteractionColors.touchSwitchStateColors
        } else if (isFocused) {
            switchInteractionColors.focusSwitchStateColors
        } else if (isHovered) {
            switchInteractionColors.hoverSwitchStateColors
        } else {
            switchInteractionColors.defaultSwitchStateColors
        }
    }

    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> isPressed = true
                is PressInteraction.Release,
                is PressInteraction.Cancel -> isPressed = false
                is FocusInteraction.Focus -> isFocused = true
                is FocusInteraction.Unfocus -> isFocused = false
                is HoverInteraction.Enter -> isHovered = true
                is HoverInteraction.Exit -> isHovered = false
            }
        }
    }

    Box(
        modifier = modifier
            .height(33.dp)
            .aspectRatio(1.8f)
            .then(
                if (isFocused) {
                    Modifier.border(
                        width = 2.dp,
                        color = switchStateColors.focusBorderColor,
                        shape = RoundedCornerShape(20.dp)
                    )
                } else {
                    Modifier
                }
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = !disabled
            ) {
                isChecked = !isChecked
                onCheckedChange(isChecked)
            }
            .hoverable(interactionSource = interactionSource)
            .focusable(interactionSource = interactionSource),
        contentAlignment = Alignment.Center
    ) {
        var trackWidth by remember { mutableIntStateOf(0) }
        var thumbWidth by remember { mutableIntStateOf(0) }
        var thumbOffset by remember(animateOffset.value, trackWidth, thumbWidth) {
            mutableFloatStateOf(
                ((trackWidth - thumbWidth) * animateOffset.value)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .aspectRatio(2.1f)
                .background(
                    color = if (isChecked) {
                        if (emphasized) switchStateColors.selectedSwitchColors.containerColor else switchStateColors.notEmphasizedSwitchColors.containerColor
                    } else {
                        switchStateColors.unselectedSwitchColors.containerColor
                    },
                    shape = CircleShape
                )
                .onSizeChanged { trackWidth = it.width },
            Alignment.CenterStart
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(if (isFocused) 0.9f else 1f)
                    .aspectRatio(1f)
                    .offset { IntOffset(thumbOffset.toInt(), 0) }
                    .background(
                        color = if (isChecked) {
                            if (emphasized) switchStateColors.selectedSwitchColors.contentBorderColor else switchStateColors.notEmphasizedSwitchColors.contentBorderColor
                        } else {
                            switchStateColors.unselectedSwitchColors.contentBorderColor
                        },
                        shape = CircleShape
                    )
                    .onSizeChanged { thumbWidth = it.width },
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 2.3.dp, horizontal = 2.3.dp)
                        .background(
                            color = if (isChecked) {
                                if (emphasized) switchStateColors.selectedSwitchColors.contentColor else switchStateColors.notEmphasizedSwitchColors.contentColor
                            } else {
                                switchStateColors.unselectedSwitchColors.contentColor
                            },
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

object SwitchDefaults {
    @Composable
    fun switchInteractionColors(
        defaultSwitchStateColors: SwitchStateColors = defaultSwitchStateColors(),
        hoverSwitchStateColors: SwitchStateColors = hoverSwitchStateColors(),
        touchSwitchStateColors: SwitchStateColors = touchSwitchStateColors(),
        focusSwitchStateColors: SwitchStateColors = focusSwitchStateColors(),
        disabledSwitchStateColors: SwitchStateColors = disabledFocusSwitchStateColors(),
    ): SwitchInteractionColors = SwitchInteractionColors(
        defaultSwitchStateColors = defaultSwitchStateColors,
        hoverSwitchStateColors = hoverSwitchStateColors,
        touchSwitchStateColors = touchSwitchStateColors,
        focusSwitchStateColors = focusSwitchStateColors,
        disabledSwitchStateColors = disabledSwitchStateColors
    )

    @Composable
    fun defaultSwitchStateColors(
        selectedSwitchColors: SwitchColors = selectedSwitchColors(),
        unselectedSwitchColors: SwitchColors = unselectedSwitchColors(),
        notEmphasizedSwitchColors: SwitchColors = notEmphasizedSwitchColors(),
        focusBorderColor: Color = KoinTheme.colors.primary700
    ): SwitchStateColors = SwitchStateColors(
        selectedSwitchColors = selectedSwitchColors,
        unselectedSwitchColors = unselectedSwitchColors,
        notEmphasizedSwitchColors = notEmphasizedSwitchColors,
        focusBorderColor = focusBorderColor
    )

    @Composable
    fun hoverSwitchStateColors(
        selectedSwitchColors: SwitchColors = selectedSwitchColors(containerColor = KoinTheme.colors.primary600),
        unselectedSwitchColors: SwitchColors = unselectedSwitchColors(contentBorderColor = KoinTheme.colors.neutral600),
        notEmphasizedSwitchColors: SwitchColors = notEmphasizedSwitchColors(
            containerColor = KoinTheme.colors.neutral600,
            contentBorderColor = KoinTheme.colors.neutral600
        ),
        focusBorderColor: Color = KoinTheme.colors.primary700
    ): SwitchStateColors = SwitchStateColors(
        selectedSwitchColors = selectedSwitchColors,
        unselectedSwitchColors = unselectedSwitchColors,
        notEmphasizedSwitchColors = notEmphasizedSwitchColors,
        focusBorderColor = focusBorderColor
    )

    @Composable
    fun touchSwitchStateColors(
        selectedSwitchColors: SwitchColors = selectedSwitchColors(
            containerColor = KoinTheme.colors.primary800,
            contentBorderColor = KoinTheme.colors.primary800
        ),
        unselectedSwitchColors: SwitchColors = unselectedSwitchColors(contentBorderColor = KoinTheme.colors.neutral800),
        notEmphasizedSwitchColors: SwitchColors = notEmphasizedSwitchColors(
            containerColor = KoinTheme.colors.neutral800,
            contentBorderColor = KoinTheme.colors.neutral800
        ),
        focusBorderColor: Color = KoinTheme.colors.primary700
    ): SwitchStateColors = SwitchStateColors(
        selectedSwitchColors = selectedSwitchColors,
        unselectedSwitchColors = unselectedSwitchColors,
        notEmphasizedSwitchColors = notEmphasizedSwitchColors,
        focusBorderColor = focusBorderColor
    )

    @Composable
    fun focusSwitchStateColors(
        selectedSwitchColors: SwitchColors = selectedSwitchColors(
            containerColor = KoinTheme.colors.primary600,
            contentBorderColor = KoinTheme.colors.primary600
        ),
        unselectedSwitchColors: SwitchColors = unselectedSwitchColors(contentBorderColor = KoinTheme.colors.neutral600),
        notEmphasizedSwitchColors: SwitchColors = notEmphasizedSwitchColors(
            containerColor = KoinTheme.colors.neutral600,
            contentBorderColor = KoinTheme.colors.neutral600
        ),
        focusBorderColor: Color = KoinTheme.colors.primary700
    ): SwitchStateColors = SwitchStateColors(
        selectedSwitchColors = selectedSwitchColors,
        unselectedSwitchColors = unselectedSwitchColors,
        notEmphasizedSwitchColors = notEmphasizedSwitchColors,
        focusBorderColor = focusBorderColor
    )

    @Composable
    fun disabledFocusSwitchStateColors(
        selectedSwitchColors: SwitchColors = selectedSwitchColors(
            containerColor = KoinTheme.colors.neutral400,
            contentBorderColor = KoinTheme.colors.neutral400
        ),
        unselectedSwitchColors: SwitchColors = unselectedSwitchColors(contentBorderColor = KoinTheme.colors.neutral400),
        notEmphasizedSwitchColors: SwitchColors = notEmphasizedSwitchColors(
            containerColor = KoinTheme.colors.neutral400,
            contentBorderColor = KoinTheme.colors.neutral400
        ),
        focusBorderColor: Color = KoinTheme.colors.primary700
    ): SwitchStateColors = SwitchStateColors(
        selectedSwitchColors = selectedSwitchColors,
        unselectedSwitchColors = unselectedSwitchColors,
        notEmphasizedSwitchColors = notEmphasizedSwitchColors,
        focusBorderColor = focusBorderColor
    )

    @Composable
    fun selectedSwitchColors(
        containerColor: Color = KoinTheme.colors.primary700,
        contentColor: Color = KoinTheme.colors.neutral0,
        contentBorderColor: Color = KoinTheme.colors.primary700
    ) = SwitchColors(
        containerColor = containerColor,
        contentColor = contentColor,
        contentBorderColor = contentBorderColor
    )

    @Composable
    fun unselectedSwitchColors(
        containerColor: Color = Color(0xFFE1E1E1),
        contentColor: Color = KoinTheme.colors.neutral0,
        contentBorderColor: Color = KoinTheme.colors.neutral700
    ) = SwitchColors(
        containerColor = containerColor,
        contentColor = contentColor,
        contentBorderColor = contentBorderColor
    )

    @Composable
    fun notEmphasizedSwitchColors(
        containerColor: Color = KoinTheme.colors.neutral700,
        contentColor: Color = KoinTheme.colors.neutral0,
        contentBorderColor: Color = KoinTheme.colors.neutral700
    ) = SwitchColors(
        containerColor = containerColor,
        contentColor = contentColor,
        contentBorderColor = contentBorderColor
    )
}

class SwitchInteractionColors internal constructor(
    val defaultSwitchStateColors: SwitchStateColors,
    val hoverSwitchStateColors: SwitchStateColors,
    val touchSwitchStateColors: SwitchStateColors,
    val focusSwitchStateColors: SwitchStateColors,
    val disabledSwitchStateColors: SwitchStateColors

)
class SwitchStateColors internal constructor(
    val selectedSwitchColors: SwitchColors,
    val unselectedSwitchColors: SwitchColors,
    val notEmphasizedSwitchColors: SwitchColors,
    val focusBorderColor: Color
)

class SwitchColors internal constructor(
    val containerColor: Color,
    val contentColor: Color,
    val contentBorderColor: Color,
)

@Preview
@Composable
private fun SwitchCheckedPreview() {
    Switch(
        checked = true,
        onCheckedChange = {}
    )
}

@Preview
@Composable
private fun SwitchUnCheckedPreview() {
    Switch(
        checked = false,
        onCheckedChange = {}
    )
}

@Preview
@Composable
private fun SwitchDisabledPreview() {
    Switch(
        checked = false,
        disabled = true,
        onCheckedChange = {}
    )
}

@Preview
@Composable
private fun SwitchEmphasizedPreview() {
    Switch(
        checked = true,
        emphasized = true,
        onCheckedChange = {}
    )
}
