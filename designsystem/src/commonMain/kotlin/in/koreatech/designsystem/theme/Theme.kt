package `in`.koreatech.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle

@Composable
fun KoinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides provideKoinTypography(),
        LocalTextStyle provides TextStyle.Default,
        LocalColors provides lightColors // TODO: Add darkColors when dark theme defined
    ) {
        content()
    }
}

object KoinTheme {
    val colors: KoinColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography: KoinTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
