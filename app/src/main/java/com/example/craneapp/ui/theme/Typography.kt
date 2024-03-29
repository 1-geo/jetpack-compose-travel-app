package com.example.craneapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.craneapp.R

private val light = Font(R.font.raleway_light, FontWeight.W300)
private val regular = Font(R.font.raleway_regular, FontWeight.W400)
private val medium = Font(R.font.raleway_medium, FontWeight.W500)
private val semibold = Font(R.font.raleway_semibold, FontWeight.W600)

private val craneFontFamily = FontFamily(fonts = listOf(light, regular, medium, semibold))

val captionTextStyle = TextStyle(
    fontFamily = craneFontFamily,
    fontWeight = FontWeight.W400,
    fontSize = 16.sp
)

val craneTypography = Typography(
    displaySmall = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W300,
        fontSize = 96.sp
    ),
    displayMedium = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 60.sp
    ),
    displayLarge = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 48.sp
    ),
    titleLarge = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 34.sp
    ),
    titleMedium = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 14.sp
    ),
    bodySmall = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W300,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    labelMedium = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),
    labelSmall = TextStyle(
        fontFamily = craneFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp
    )
)
