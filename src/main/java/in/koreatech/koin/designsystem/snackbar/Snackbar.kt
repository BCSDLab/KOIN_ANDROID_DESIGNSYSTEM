package `in`.koreatech.koin.designsystem.snackbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import `in`.koreatech.koin.designsystem.KoinTheme
import `in`.koreatech.koin.designsystem.R

object SnackbarDefaults {
    val snackbarTextStyle
        @Composable get() = KoinTheme.typography.body2.merge(color = KoinTheme.colors.neutral0)

    val snackbarBackgroundColor
        @Composable get() = KoinTheme.colors.neutral600

    val snackbarButtonBackgroundColor
        @Composable get() = KoinTheme.colors.neutral700

    val snackbarOutsidePadding = PaddingValues(horizontal = 24.dp)

    val snackbarInnerPadding = PaddingValues(vertical = 8.dp, horizontal = 20.dp)

    val snackbarCornerShape = RoundedCornerShape(8.dp)
}

@Composable
fun Snackbar(
    snackbarData: SnackbarData,
    modifier: Modifier = Modifier,
    snackBarTextStyle: TextStyle = SnackbarDefaults.snackbarTextStyle,
    snackbarBackgroundColor: Color = SnackbarDefaults.snackbarBackgroundColor,
    snackbarButtonBackgroundColor: Color = SnackbarDefaults.snackbarButtonBackgroundColor,
    snackbarOutsidePadding: PaddingValues = SnackbarDefaults.snackbarOutsidePadding,
    snackbarInnerPadding: PaddingValues = SnackbarDefaults.snackbarInnerPadding,
    snackbarCornerShape: Shape = SnackbarDefaults.snackbarCornerShape
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = SnackbarMinHeight)
            .padding(snackbarOutsidePadding)
            .clip(snackbarCornerShape)
            .background(snackbarBackgroundColor)
            .padding(snackbarInnerPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val icon = when (snackbarData.visuals.variant) {
            SnackbarVariant.Informative -> ImageVector.vectorResource(R.drawable.ic_snackbar_informative)
            SnackbarVariant.Positive -> ImageVector.vectorResource(R.drawable.ic_snackbar_positive)
            SnackbarVariant.Negative -> ImageVector.vectorResource(R.drawable.ic_snackbar_negative)
            SnackbarVariant.Neutral -> null
        }

        icon?.let {
            Image(
                modifier = Modifier.size(16.dp),
                imageVector = it,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(12.dp))
        }

        BasicText(
            text = snackbarData.visuals.message,
            style = snackBarTextStyle
        )

        snackbarData.visuals.actionLabel?.let {
            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(snackbarButtonBackgroundColor, CircleShape)
                    .clickable {
                        snackbarData.performAction()
                    }
                    .padding(vertical = 8.dp, horizontal = 20.dp)
            ) {
                BasicText(
                    style = snackBarTextStyle,
                    text = it
                )
            }
        }
    }
}

private val SnackbarMinHeight = 56.dp
