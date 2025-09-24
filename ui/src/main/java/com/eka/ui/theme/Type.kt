package com.eka.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.eka.ui.R

// Define Inter font family
val InterFontFamily = FontFamily(
    Font(R.font.inter_extra_light, FontWeight.ExtraLight),
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_extra_bold, FontWeight.ExtraBold),
)

internal fun Typography.withCustomFontFamily(fontFamily: FontFamily): Typography {
    return this.copy(
        displayLarge = this.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = this.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = this.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = this.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = this.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = this.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = this.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = this.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = this.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = this.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = this.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = this.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = this.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = this.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = this.labelSmall.copy(fontFamily = fontFamily)
    )
}

fun TextStyle.Bold(): TextStyle {
    return this.copy(fontWeight = FontWeight.Bold)
}

fun TextStyle.Medium(): TextStyle {
    return this.copy(fontWeight = FontWeight.Medium)
}

fun TextStyle.SemiBold(): TextStyle {
    return this.copy(fontWeight = FontWeight.SemiBold)
}

fun TextStyle.Light(): TextStyle {
    return this.copy(fontWeight = FontWeight.Light)
}

fun TextStyle.ExtraLight(): TextStyle {
    return this.copy(fontWeight = FontWeight.ExtraLight)
}

fun TextStyle.Regular(): TextStyle {
    return this.copy(fontWeight = FontWeight.Normal)
}

fun TextStyle.ExtraBold(): TextStyle {
    return this.copy(fontWeight = FontWeight.ExtraBold)
}

val defaultUIKitTypography = Typography().withCustomFontFamily(
    fontFamily = InterFontFamily
)

fun Typography.displayLargeEmphasized(): TextStyle {
    return displayLarge.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.displayMediumEmphasized(): TextStyle {
    return displayMedium.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.displaySmallEmphasized(): TextStyle {
    return displaySmall.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.headlineLargeEmphasized(): TextStyle {
    return headlineLarge.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.headlineMediumEmphasized(): TextStyle {
    return headlineMedium.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.headlineSmallEmphasized(): TextStyle {
    return headlineSmall.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.titleLargeEmphasized(): TextStyle {
    return titleLarge.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.titleMediumEmphasized(): TextStyle {
    return titleMedium.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.titleSmallEmphasized(): TextStyle {
    return titleSmall.copy(
        fontWeight = FontWeight.Medium
    )
}

fun Typography.bodyLargeEmphasized(): TextStyle {
    return bodyLarge.copy(
        fontWeight = FontWeight.SemiBold
    )
}

fun Typography.bodyMediumEmphasized(): TextStyle {
    return bodyMedium.copy(
        fontWeight = FontWeight.SemiBold
    )
}

fun Typography.bodySmallEmphasized(): TextStyle {
    return bodySmall.copy(
        fontWeight = FontWeight.SemiBold
    )
}

fun Typography.labelLargeEmphasized(): TextStyle {
    return labelLarge.copy(
        fontWeight = FontWeight.SemiBold
    )
}

fun Typography.labelMediumEmphasized(): TextStyle {
    return labelMedium.copy(
        fontWeight = FontWeight.SemiBold
    )
}

fun Typography.labelSmallEmphasized(): TextStyle {
    return labelSmall.copy(
        fontWeight = FontWeight.SemiBold
    )
}