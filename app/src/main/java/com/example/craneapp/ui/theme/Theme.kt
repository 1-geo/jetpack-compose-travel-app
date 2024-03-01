package com.example.craneapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


/**
 * Colors
 */

// define colors
val crane_caption = Color(0x80FFFFFF)
val crane_divider_color = Color.LightGray
val crane_white = Color.White
val crane_purple_700 = Color(0xFF720D5D)
val crane_purple_800 = Color(0xFF5D1049)


@SuppressLint("ConflictingOnColor")
val craneColors = lightColorScheme(
    // bg
    primary = crane_purple_800,             // primary(light) - tabrow, backdrop, button
    surface = crane_purple_800,             // surface(darker) - surface

    // on
    onPrimary = crane_white,
    onSurface = crane_white,                // onSurface - both surface and primary content≤
)

// override any custom components with colors as needed from defined colors.


/**
 * Shapes
 */
val craneShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

@Composable
fun CraneTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = craneColors,
        typography = craneTypography,
        content = content
    )
}