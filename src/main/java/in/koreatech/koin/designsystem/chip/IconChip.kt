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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastFirst
import `in`.koreatech.koin.designsystem.KoinTheme
import `in`.koreatech.koin.designsystem.LocalContentColor
import `in`.koreatech.koin.designsystem.R
import `in`.koreatech.koin.designsystem.icon.Icon

class IconChipStyle(
    val containerColor: Color,
    val elevation: Dp,
    val ambientColor: Color,
    val spotColor: Color,
    val iconColor: Color,
    val iconSize: Dp,
    val border: BorderStroke,
    val shape: Shape
)

object IconChipDefaults {
    @Composable
    fun primaryIconChipColors(
        containerColor: Color = KoinTheme.colors.primary700,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral0,
        iconSize: Dp = 16.dp
    ): IconChipStyle = IconChipStyle(
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
    fun outlinedPrimaryIconChipColors(
        containerColor: Color = KoinTheme.colors.neutral50,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(1.dp, KoinTheme.colors.primary700),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.primary700,
        iconSize: Dp = 16.dp
    ): IconChipStyle = IconChipStyle(
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
    fun negativeIconChipColors(
        containerColor: Color = KoinTheme.colors.danger700,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral0,
        iconSize: Dp = 16.dp
    ): IconChipStyle = IconChipStyle(
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
    fun outlinedNegativeIconChipColors(
        containerColor: Color = KoinTheme.colors.neutral50,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(1.dp, KoinTheme.colors.danger700),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.danger700,
        iconSize: Dp = 16.dp
    ): IconChipStyle = IconChipStyle(
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
    fun secondaryIconChipColors(
        containerColor: Color = KoinTheme.colors.neutral200,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(0.dp, containerColor),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral600,
        iconSize: Dp = 16.dp
    ): IconChipStyle = IconChipStyle(
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
    fun outlinedSecondaryIconChipColors(
        containerColor: Color = KoinTheme.colors.neutral50,
        elevation: Dp = 0.dp,
        ambientColor: Color = Color.Unspecified,
        spotColor: Color = Color.Unspecified,
        border: BorderStroke = BorderStroke(1.dp, KoinTheme.colors.neutral300),
        shape: Shape = RoundedCornerShape(50.dp),
        iconColor: Color = KoinTheme.colors.neutral600,
        iconSize: Dp = 16.dp
    ): IconChipStyle = IconChipStyle(
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
fun IconChip(
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    iconChipStyle: IconChipStyle = IconChipDefaults.primaryIconChipColors(),
    onClick: () -> Unit = {}
) {
    IconChipContent(
        icon = icon,
        iconChipStyle = iconChipStyle,
        modifier = modifier
            .clip(iconChipStyle.shape)
            .clickable(onClick = onClick)
            .semantics {
                this.role = Role.Button
            }
    )
}

@Composable
private fun IconChipContent(
    icon: @Composable () -> Unit,
    iconChipStyle: IconChipStyle,
    modifier: Modifier = Modifier
) {
    Layout(
        modifier = modifier
            .shadow(
                elevation = iconChipStyle.elevation,
                shape = iconChipStyle.shape,
                ambientColor = iconChipStyle.ambientColor,
                spotColor = iconChipStyle.spotColor
            )
            .border(iconChipStyle.border, iconChipStyle.shape)
            .clip(iconChipStyle.shape)
            .background(iconChipStyle.containerColor, iconChipStyle.shape),
        content = {
            Box(
                modifier = Modifier
                    .layoutId(IconLayoutId)
                    .size(iconChipStyle.iconSize)
            ) {
                CompositionLocalProvider(LocalContentColor provides iconChipStyle.iconColor) {
                    icon()
                }
            }
        }
    ) { measurables, constraints ->
        val iconPlaceable = measurables.fastFirst { it.layoutId == IconLayoutId }.measure(constraints)
        val iconWidth = iconPlaceable.measuredWidth
        val iconHeight = iconPlaceable.measuredHeight

        val verticalPadding = ChipVerticalPadding.roundToPx()
        val horizontalPadding = ChipHorizontalPadding.roundToPx()

        val width = iconWidth + horizontalPadding * 2
        val height = iconHeight + verticalPadding * 2

        layout(width, height) {
            iconPlaceable.placeRelative(horizontalPadding, Alignment.CenterVertically.align(iconHeight, height))
        }
    }
}

private val ChipVerticalPadding = 7.dp
private val ChipHorizontalPadding = 7.dp

private const val IconLayoutId = "icon"
