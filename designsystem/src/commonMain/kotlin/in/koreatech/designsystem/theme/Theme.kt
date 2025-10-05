package `in`.koreatech.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun KoinTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTypography provides provideKoinTypography(),
        LocalColors provides lightColors // TODO: Add darkColors when dark theme defined
    ) {
        content()
    }
}
