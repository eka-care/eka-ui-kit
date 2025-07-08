package com.eka.ui.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
            XLARGE, LARGE, MEDIUM -> 8
            SMALL, XSMALL -> 4
        }
    }

    fun paddingValues(isLeadingIconNull: Boolean, isTrailingIconNull: Boolean) = when (this) {
        XLARGE, LARGE, MEDIUM -> PaddingValues(
            top = 0.dp,
            start = if (isLeadingIconNull) 24.dp else 16.dp,
            bottom = 0.dp,
            end = if (isTrailingIconNull) 24.dp else 16.dp
        )

        SMALL -> PaddingValues(
            top = 0.dp,
            start = if (isLeadingIconNull) 16.dp else 8.dp,
            bottom = 0.dp,
            end = if (isTrailingIconNull) 16.dp else 8.dp
        )

        XSMALL -> PaddingValues(
            top = 0.dp,
            start = if (isLeadingIconNull) 8.dp else 4.dp,
            bottom = 0.dp,
            end = if (isTrailingIconNull) 8.dp else 4.dp
        )
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
    val buttonColor = getButtonColors(buttonStyle = buttonStyle)
    val derivedShape = getButtonShape(buttonShape = buttonShape, buttonSize = buttonSize)

    Button(
        onClick = onClick,
        modifier = modifier,
        shape = derivedShape,
        colors = buttonColor,
        enabled = enabled,
        contentPadding = buttonSize.paddingValues(
            isLeadingIconNull = leadingIcon == null,
            isTrailingIconNull = trailingIcon == null
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp
        ),
        content = {
//            EkaButtonContent(
//                label = label,
//                buttonSize = buttonSize,
//                leadingIcon = leadingIcon,
//                trailingIcon = trailingIcon
//            )
        }
    )
}

@Composable
internal fun getButtonShape(buttonShape: EkaButtonShape, buttonSize: EkaButtonSize): Shape {
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
internal fun getButtonColors(buttonStyle: EkaButtonStyle): ButtonColors {
    return when (buttonStyle) {
        EkaButtonStyle.FILLED -> {
            ButtonDefaults.buttonColors(
                containerColor = EkaTheme.colors.primary,
                contentColor = EkaTheme.colors.onPrimary
            )
        }

        EkaButtonStyle.OUTLINED -> {
            ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White,
                contentColor = EkaTheme.colors.onSurfaceVariant,
            )
        }

        EkaButtonStyle.TEXT -> {
            ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                contentColor = EkaTheme.colors.primary
            )
        }

        EkaButtonStyle.TONAL -> {
            ButtonDefaults.outlinedButtonColors(
                containerColor = EkaTheme.colors.secondaryContainer,
                contentColor = EkaTheme.colors.onSecondaryContainer
            )
        }

        EkaButtonStyle.ELEVATED -> {
            ButtonDefaults.outlinedButtonColors(
                containerColor = EkaTheme.colors.surfaceContainerLow,
                contentColor = EkaTheme.colors.primary
            )
        }
    }
}