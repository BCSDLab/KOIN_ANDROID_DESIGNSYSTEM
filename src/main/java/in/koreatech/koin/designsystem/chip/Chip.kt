package `in`.koreatech.koin.designsystem.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import androidx.compose.ui.util.fastFirstOrNull
import `in`.koreatech.koin.designsystem.KoinTheme
import `in`.koreatech.koin.designsystem.LocalContentColor
import `in`.koreatech.koin.designsystem.LocalTextStyle
import kotlin.math.max

class ChipStyle(
    val textColor: Color,
    val textStyle: TextStyle,
    val containerColor: Color,
    val elevation: Dp,
    val ambientColor: Color,
    val spotColor: Color,
    val iconColor: Color,
    val iconSize: Dp,
    val border: BorderStroke,
    val shape: Shape
)

object ChipDefaults {
    @Composable
    fun primaryChipColors(
        textColor: Color = KoinTheme.colors.neutral0,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.primary700,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral0,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )

    @Composable
    fun outlinedPrimaryChipColors(
        textColor: Color = KoinTheme.colors.primary700,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.neutral50,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(1.dp, KoinTheme.colors.primary700),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.primary700,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )

    @Composable
    fun negativeChipColors(
        textColor: Color = KoinTheme.colors.neutral0,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.danger700,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral0,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )

    @Composable
    fun outlinedNegativeChipColors(
        textColor: Color = KoinTheme.colors.danger700,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.neutral50,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(1.dp, KoinTheme.colors.danger700),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.danger700,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )

    @Composable
    fun secondaryChipColors(
        textColor: Color = KoinTheme.colors.neutral600,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.neutral200,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral600,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )

    @Composable
    fun outlinedSecondaryChipColors(
        textColor: Color = KoinTheme.colors.neutral600,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.neutral50,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(1.dp, KoinTheme.colors.neutral300),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral600,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )

    @Composable
    fun disabledChipColors(
        textColor: Color = KoinTheme.colors.neutral400,
        textStyle: TextStyle = KoinTheme.typography.body2,
        containerColor: Color = KoinTheme.colors.neutral200,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral400,
        iconSize: Dp = 16.dp
    ): ChipStyle = ChipStyle(
        textColor = textColor,
        textStyle = textStyle,
        containerColor = containerColor,
        elevation = elevation,
        ambientColor = ambientColor,
        spotColor = spotColor,
        border = border,
        shape = shape,
        iconColor = iconColor,
        iconSize = iconSize
    )
}

@Composable
fun Chip(
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    chipStyle: ChipStyle = ChipDefaults.primaryChipColors(),
    leadingIcon: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    ChipContent(
        label = label,
        leadingIcon = leadingIcon,
        chipStyle = chipStyle,
        modifier = modifier
            .clip(chipStyle.shape)
            .clickable(onClick = onClick)
            .semantics {
                this.role = Role.Button
            }
    )
}

@Composable
private fun ChipContent(
    label: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    chipStyle: ChipStyle,
    modifier: Modifier = Modifier
) {
    Layout(
        modifier = modifier
            .shadow(
                elevation = chipStyle.elevation,
                shape = chipStyle.shape,
                ambientColor = chipStyle.ambientColor,
                spotColor = chipStyle.spotColor
            )
            .border(chipStyle.border, chipStyle.shape)
            .clip(chipStyle.shape)
            .background(chipStyle.containerColor, chipStyle.shape),
        content = {
            if (leadingIcon != null) {
                Box(
                    modifier = Modifier
                        .layoutId(LeadingIconLayoutId)
                        .size(chipStyle.iconSize)
                ) {
                    CompositionLocalProvider(LocalContentColor provides chipStyle.iconColor) {
                        leadingIcon()
                    }
                }
            }
            Box(
                modifier = Modifier.layoutId(LabelLayoutId)
            ) {
                CompositionLocalProvider(LocalTextStyle provides chipStyle.textStyle.merge(color = chipStyle.textColor)) {
                    label()
                }
            }
        }
    ) { measurables, constraints ->
        val labelPlaceable = measurables.fastFirst { it.layoutId == LabelLayoutId }.measure(constraints)
        val labelWidth = labelPlaceable.measuredWidth
        val labelHeight = labelPlaceable.measuredHeight

        val leadingIconPlaceable = measurables.fastFirstOrNull { it.layoutId == LeadingIconLayoutId }?.measure(constraints)
        val leadingIconWidth = leadingIconPlaceable?.measuredWidth ?: 0
        val leadingIconHeight = leadingIconPlaceable?.measuredHeight ?: 0

        val startPadding = (if (leadingIcon != null) ChipWithIconStartPadding else ChipHorizontalPadding).roundToPx()
        val endPadding = (if (leadingIcon != null) ChipWithIconEndPadding else ChipHorizontalPadding).roundToPx()
        val verticalPadding = ChipVerticalPadding.roundToPx()
        val innerPadding = if (leadingIcon != null) ChipWithIconInnerPadding.roundToPx() else 0

        val width = labelWidth + leadingIconWidth + startPadding + endPadding + innerPadding
        val height = max(labelHeight, leadingIconHeight) + verticalPadding * 2

        layout(width, height) {
            leadingIconPlaceable?.placeRelative(startPadding, Alignment.CenterVertically.align(leadingIconHeight, height))
            labelPlaceable.placeRelative(leadingIconWidth + startPadding + innerPadding, Alignment.CenterVertically.align(labelHeight, height))
        }
    }
}

private val ChipVerticalPadding = 7.dp
private val ChipHorizontalPadding = 17.dp
private val ChipWithIconStartPadding = 14.dp
private val ChipWithIconEndPadding = 15.dp
private val ChipWithIconInnerPadding = 8.dp

private const val LeadingIconLayoutId = "leadingIcon"
private const val LabelLayoutId = "label"
