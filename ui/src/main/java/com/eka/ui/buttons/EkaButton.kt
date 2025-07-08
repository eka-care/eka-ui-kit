package com.eka.ui.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eka.ui.common.HorizontalSpacer
import com.eka.ui.theme.EkaTheme

enum class EkaButtonStyle {
    FILLED,
    OUTLINED,
    TEXT,
    TONAL,
    ELEVATED,
}

enum class EkaButtonSize(val size: Dp) {
    XSMALL(32.dp),
    SMALL(40.dp),
    MEDIUM(56.dp),
    LARGE(96.dp),
    XLARGE(136.dp);

    companion object {
        val DEFAULT = MEDIUM
    }

    fun iconSize(): Dp {
        return when (this) {
            XLARGE, LARGE, MEDIUM -> 24.dp
            SMALL, XSMALL -> 16.dp
        }
    }

    fun iconSpace(): Int {
        return when (this) {
            XLARGE -> 16
            LARGE -> 12
            MEDIUM, SMALL -> 8
            XSMALL -> 4
        }
    }

    fun borderWidth(): Dp {
        return when (this) {
            XLARGE, LARGE -> 2.dp
            MEDIUM, SMALL, XSMALL -> 1.dp
        }
    }

    fun paddingValues(isLeadingIconNull: Boolean, isTrailingIconNull: Boolean) = when (this) {
        XLARGE -> PaddingValues(
            top = 48.dp,
            start = if (isLeadingIconNull) 64.dp else 32.dp,
            bottom = 48.dp,
            end = if (isTrailingIconNull) 64.dp else 32.dp
        )

        LARGE -> PaddingValues(
            top = 32.dp,
            start = if (isLeadingIconNull) 48.dp else 32.dp,
            bottom = 32.dp,
            end = if (isTrailingIconNull) 48.dp else 32.dp
        )

        MEDIUM -> PaddingValues(
            top = 16.dp,
            start = if (isLeadingIconNull) 24.dp else 16.dp,
            bottom = 16.dp,
            end = if (isTrailingIconNull) 24.dp else 16.dp
        )

        SMALL -> PaddingValues(
            top = 10.dp,
            start = if (isLeadingIconNull) 16.dp else 12.dp,
            bottom = 10.dp,
            end = if (isTrailingIconNull) 16.dp else 12.dp
        )

        XSMALL -> PaddingValues(
            top = 6.dp,
            start = if (isLeadingIconNull) 12.dp else 8.dp,
            bottom = 6.dp,
            end = if (isTrailingIconNull) 12.dp else 8.dp
        )
    }

    @Composable
    fun textStyle() = when (this) {
        XLARGE -> EkaTheme.typography.headlineLarge
        LARGE -> EkaTheme.typography.headlineSmall
        MEDIUM -> EkaTheme.typography.titleMedium
        XSMALL, SMALL -> EkaTheme.typography.labelLarge
    }
}

enum class EkaButtonShape {
    ROUNDED,
    SQUARE,
}

@Composable
fun EkaButton(
    modifier: Modifier = Modifier,
    label: String,
    style: EkaButtonStyle = EkaButtonStyle.FILLED,
    size: EkaButtonSize = EkaButtonSize.DEFAULT,
    shape: EkaButtonShape = EkaButtonShape.ROUNDED,
    enabled: Boolean = true,
    leadingIcon: EkaIcon? = null,
    trailingIcon: EkaIcon? = null,
    onClick: () -> Unit,
) {
    EkaButtonImpl(
        modifier = modifier,
        label = label,
        onClick = onClick,
        buttonStyle = style,
        buttonSize = size,
        buttonShape = shape,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
    )
}

@Composable
internal fun EkaButtonImpl(
    modifier: Modifier,
    label: String,
    buttonStyle: EkaButtonStyle,
    buttonSize: EkaButtonSize,
    buttonShape: EkaButtonShape,
    enabled: Boolean,
    leadingIcon: EkaIcon?,
    trailingIcon: EkaIcon?,
    onClick: () -> Unit,
) {
    val buttonColor = getEkaButtonColors(buttonStyle = buttonStyle)
    val derivedShape = getEkaButtonShape(buttonShape = buttonShape, buttonSize = buttonSize)

    Button(
        onClick = onClick,
        modifier = modifier
            .height(buttonSize.size),
        shape = derivedShape,
        colors = buttonColor,
        enabled = enabled,
        contentPadding = buttonSize.paddingValues(
            isLeadingIconNull = leadingIcon == null,
            isTrailingIconNull = trailingIcon == null
        ),
        border = if (buttonStyle == EkaButtonStyle.OUTLINED && enabled == false) BorderStroke(
            width = buttonSize.borderWidth(), color = EkaTheme.colors.outlineVariant
        ) else null,
        elevation = if (buttonStyle == EkaButtonStyle.ELEVATED) ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp,
            hoveredElevation = 2.dp,
            focusedElevation = 2.dp,
            disabledElevation = 0.dp,
        ) else null,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                leadingIcon?.let {
                    GetEkaIcon(
                        icon = it,
                        buttonSize = buttonSize
                    )
                    HorizontalSpacer(space = buttonSize.iconSpace())
                }
                Text(text = label, style = buttonSize.textStyle())
                trailingIcon?.let {
                    HorizontalSpacer(space = buttonSize.iconSpace())
                    GetEkaIcon(
                        icon = it,
                        buttonSize = buttonSize
                    )
                }
            }
        }
    )
}

@Composable
internal fun GetEkaIcon(icon: EkaIcon, buttonSize: EkaButtonSize) {
    icon.painterResource?.let {
        Icon(
            painter = it,
            contentDescription = icon.contentDescription,
            modifier = Modifier
                .size(buttonSize.iconSize()),
        )
    }
    icon.imageVector?.let {
        Icon(
            imageVector = it,
            contentDescription = icon.contentDescription,
            modifier = Modifier
                .size(buttonSize.iconSize())
        )
    }
}

@Composable
internal fun getEkaButtonShape(buttonShape: EkaButtonShape, buttonSize: EkaButtonSize): Shape {
    return when (buttonShape to buttonSize) {
        EkaButtonShape.ROUNDED to EkaButtonSize.XSMALL -> CircleShape
        EkaButtonShape.ROUNDED to EkaButtonSize.SMALL -> CircleShape
        EkaButtonShape.ROUNDED to EkaButtonSize.MEDIUM -> CircleShape
        EkaButtonShape.ROUNDED to EkaButtonSize.LARGE -> CircleShape
        EkaButtonShape.ROUNDED to EkaButtonSize.XLARGE -> CircleShape
        EkaButtonShape.SQUARE to EkaButtonSize.XSMALL -> EkaTheme.shapes.medium
        EkaButtonShape.SQUARE to EkaButtonSize.SMALL -> EkaTheme.shapes.medium
        EkaButtonShape.SQUARE to EkaButtonSize.MEDIUM -> EkaTheme.shapes.large
        EkaButtonShape.SQUARE to EkaButtonSize.LARGE -> EkaTheme.shapes.extraLarge
        EkaButtonShape.SQUARE to EkaButtonSize.XLARGE -> EkaTheme.shapes.extraLarge
        else -> CircleShape
    }
}

@Composable
internal fun getEkaButtonColors(buttonStyle: EkaButtonStyle): ButtonColors {
    return when (buttonStyle) {
        EkaButtonStyle.FILLED -> {
            ButtonDefaults.buttonColors(
                containerColor = EkaTheme.colors.primary,
                contentColor = EkaTheme.colors.onPrimary,
                disabledContainerColor = EkaTheme.colors.surfaceContainer,
                disabledContentColor = EkaTheme.colors.onSurfaceVariant
            )
        }

        EkaButtonStyle.OUTLINED -> {
            ButtonDefaults.outlinedButtonColors(
                containerColor = EkaTheme.colors.inverseSurface,
                contentColor = EkaTheme.colors.inverseOnSurface,
                disabledContainerColor = EkaTheme.colors.outlineVariant,
                disabledContentColor = EkaTheme.colors.onSurfaceVariant
            )
        }

        EkaButtonStyle.TEXT -> {
            ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = EkaTheme.colors.primary,
            )
        }

        EkaButtonStyle.TONAL -> {
            ButtonDefaults.buttonColors(
                containerColor = EkaTheme.colors.secondary,
                contentColor = EkaTheme.colors.onSecondary,
                disabledContainerColor = EkaTheme.colors.secondaryContainer,
                disabledContentColor = EkaTheme.colors.onSecondaryContainer
            )
        }

        EkaButtonStyle.ELEVATED -> {
            ButtonDefaults.elevatedButtonColors(
                containerColor = EkaTheme.colors.primary,
                contentColor = EkaTheme.colors.onPrimary,
                disabledContainerColor = EkaTheme.colors.surfaceContainerLow,
                disabledContentColor = EkaTheme.colors.primary
            )
        }
    }
}