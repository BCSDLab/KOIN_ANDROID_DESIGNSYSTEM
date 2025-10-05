package `in`.koreatech.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun KoinTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider {
        content()
    }
}
