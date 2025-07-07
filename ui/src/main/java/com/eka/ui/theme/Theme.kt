package com.eka.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalEkaColors = staticCompositionLocalOf {
    lightScheme
}

val LocalEkaTypography = staticCompositionLocalOf {
    Typography()
}

@Composable
fun EkaTheme(
    colorScheme: ColorScheme = lightScheme,
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = Shapes,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalEkaColors provides colorScheme,
        LocalEkaTypography provides typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object EkaTheme {
    val typography: Typography
        @Composable @ReadOnlyComposable
        get() = LocalEkaTypography.current
    val colors: ColorScheme
        @Composable @ReadOnlyComposable
        get() = LocalEkaColors.current
}

