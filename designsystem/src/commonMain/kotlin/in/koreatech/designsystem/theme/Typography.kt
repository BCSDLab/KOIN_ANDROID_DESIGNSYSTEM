package `in`.koreatech.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import `in`.koreatech.designsystem.generated.resources.Res
import `in`.koreatech.designsystem.generated.resources.pretendard_bold
import `in`.koreatech.designsystem.generated.resources.pretendard_medium
import `in`.koreatech.designsystem.generated.resources.pretendard_regular
import org.jetbrains.compose.resources.Font

@Composable
private fun pretendardFontFamily() = FontFamily(
    Font(Res.font.pretendard_bold, FontWeight.Bold, FontStyle.Normal),
    Font(Res.font.pretendard_bold, FontWeight.SemiBold, FontStyle.Normal),
    Font(Res.font.pretendard_medium, FontWeight.Medium, FontStyle.Normal),
    Font(Res.font.pretendard_regular, FontWeight.Normal, FontStyle.Normal)
)

private val koinTypography = KoinTypography(
    display1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 48.sp
    ),
    display2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 42.sp
    ),
    title1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 36.sp
    ),
    title2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 35.2.sp
    ),
    title3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 32.sp
    ),
    title3Strong = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 32.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 28.8.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.6.sp
    ),
    body1Strong = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 25.6.sp
    ),
    body1Stronger = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 25.6.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 25.6.sp
    ),
    body2Strong = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 22.4.sp
    ),
    body2Stronger = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 22.4.sp
    ),
    caption1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 19.2.sp
    ),
    caption1Strong = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 19.2.sp
    ),
    caption1Stronger = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 19.2.sp
    ),
    caption2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 17.6.sp
    ),
    caption2Strong = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 17.6.sp
    )
)

@Composable
fun provideKoinTypography(): KoinTypography {
    val fontFamily = pretendardFontFamily()

    return koinTypography.copy(
        display1 = koinTypography.display1.copy(fontFamily = fontFamily),
        display2 = koinTypography.display2.copy(fontFamily = fontFamily),
        title1 = koinTypography.title1.copy(fontFamily = fontFamily),
        title2 = koinTypography.title2.copy(fontFamily = fontFamily),
        title3 = koinTypography.title3.copy(fontFamily = fontFamily),
        title3Strong = koinTypography.title3Strong.copy(fontFamily = fontFamily),
        subtitle1 = koinTypography.subtitle1.copy(fontFamily = fontFamily),
        body1 = koinTypography.body1.copy(fontFamily = fontFamily),
        body1Strong = koinTypography.body1Strong.copy(fontFamily = fontFamily),
        body1Stronger = koinTypography.body1Stronger.copy(fontFamily = fontFamily),
        body2 = koinTypography.body2.copy(fontFamily = fontFamily),
        body2Strong = koinTypography.body2Strong.copy(fontFamily = fontFamily),
        body2Stronger = koinTypography.body2Stronger.copy(fontFamily = fontFamily),
        caption1 = koinTypography.caption1.copy(fontFamily = fontFamily),
        caption1Strong = koinTypography.caption1Strong.copy(fontFamily = fontFamily),
        caption1Stronger = koinTypography.caption1Stronger.copy(fontFamily = fontFamily),
        caption2 = koinTypography.caption2.copy(fontFamily = fontFamily),
        caption2Strong = koinTypography.caption2Strong.copy(fontFamily = fontFamily)
    )
}

@Immutable
data class KoinTypography(
    val display1: TextStyle,
    val display2: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val title3Strong: TextStyle,
    val subtitle1: TextStyle,
    val body1: TextStyle,
    val body1Strong: TextStyle,
    val body1Stronger: TextStyle,
    val body2: TextStyle,
    val body2Strong: TextStyle,
    val body2Stronger: TextStyle,
    val caption1: TextStyle,
    val caption1Strong: TextStyle,
    val caption1Stronger: TextStyle,
    val caption2: TextStyle,
    val caption2Strong: TextStyle
)

val LocalTypography = staticCompositionLocalOf { koinTypography }
