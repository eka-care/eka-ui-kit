package com.eka.ui.previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eka.ui.buttons.EkaButton
import com.eka.ui.buttons.EkaButtonShape
import com.eka.ui.buttons.EkaButtonSize
import com.eka.ui.buttons.EkaButtonStyle
import com.eka.ui.buttons.EkaIcon
import com.eka.ui.theme.EkaTheme

// Preview for all button variations
@Preview(showBackground = true, widthDp = 1200, heightDp = 2400)
@Composable
fun EkaButtonCompletePreview() {
    EkaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF5F5F5)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Title
                Text(
                    text = "EkaButton Component Preview",
                    style = EkaTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // All button styles
                EkaButtonStyle.entries.forEach { style ->
                    ButtonStyleSection(style = style)
                    if (style != EkaButtonStyle.entries.last()) {
                        Divider(modifier = Modifier.padding(vertical = 8.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun ButtonStyleSection(style: EkaButtonStyle) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Style title
        Text(
            text = "${style.name} Style",
            style = EkaTheme.typography.titleLarge,
            color = EkaTheme.colors.primary
        )

        // All sizes for this style
        EkaButtonSize.values().forEach { size ->
            ButtonSizeRow(style = style, size = size)
        }
    }
}

@Composable
private fun ButtonSizeRow(style: EkaButtonStyle, size: EkaButtonSize) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Size label
        Text(
            text = "Size: ${size.name} (${size.size})",
            style = EkaTheme.typography.labelMedium,
            color = EkaTheme.colors.onSurfaceVariant
        )

        // Rounded shape buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Basic button
            EkaButton(
                label = "Button",
                style = style,
                size = size,
                shape = EkaButtonShape.ROUNDED,
                onClick = {}
            )

            // With leading icon
            EkaButton(
                label = "Search",
                style = style,
                size = size,
                shape = EkaButtonShape.ROUNDED,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Search,
                    contentDescription = "Search"
                ),
                onClick = {}
            )

            // With trailing icon
            EkaButton(
                label = "Next",
                style = style,
                size = size,
                shape = EkaButtonShape.ROUNDED,
                trailingIcon = EkaIcon(
                    icon = Icons.Default.ArrowForward,
                    contentDescription = "Arrow"
                ),
                onClick = {}
            )

            // With both icons
            EkaButton(
                label = "Add",
                style = style,
                size = size,
                shape = EkaButtonShape.ROUNDED,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Add,
                    contentDescription = "Add"
                ),
                trailingIcon = EkaIcon(
                    icon = Icons.Default.ArrowForward,
                    contentDescription = "Arrow"
                ),
                onClick = {}
            )

            // Disabled state
            EkaButton(
                label = "Disabled",
                style = style,
                size = size,
                shape = EkaButtonShape.ROUNDED,
                enabled = false,
                onClick = {}
            )
        }

        // Square shape buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Basic button
            EkaButton(
                label = "Button",
                style = style,
                size = size,
                shape = EkaButtonShape.SQUARE,
                onClick = {}
            )

            // With leading icon
            EkaButton(
                label = "Settings",
                style = style,
                size = size,
                shape = EkaButtonShape.SQUARE,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Settings,
                    contentDescription = "Settings"
                ),
                onClick = {}
            )

            // With trailing icon
            EkaButton(
                label = "Like",
                style = style,
                size = size,
                shape = EkaButtonShape.SQUARE,
                trailingIcon = EkaIcon(
                    icon = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                ),
                onClick = {}
            )

            // With both icons
            EkaButton(
                label = "Add",
                style = style,
                size = size,
                shape = EkaButtonShape.SQUARE,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Add,
                    contentDescription = "Add"
                ),
                trailingIcon = EkaIcon(
                    icon = Icons.Default.ArrowForward,
                    contentDescription = "Arrow"
                ),
                onClick = {}
            )

            // Disabled state
            EkaButton(
                label = "Disabled",
                style = style,
                size = size,
                shape = EkaButtonShape.SQUARE,
                enabled = false,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Settings,
                    contentDescription = "Settings"
                ),
                onClick = {}
            )
        }
    }
}

// Individual previews for each style
@Preview(showBackground = true, widthDp = 400)
@Composable
fun EkaButtonFilledPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EkaButton(
                label = "Filled Button",
                style = EkaButtonStyle.FILLED,
                onClick = {}
            )
            EkaButton(
                label = "With Icon",
                style = EkaButtonStyle.FILLED,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Add,
                    contentDescription = "Add"
                ),
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun EkaButtonOutlinedPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EkaButton(
                label = "Outlined Button",
                style = EkaButtonStyle.OUTLINED,
                onClick = {}
            )
            EkaButton(
                label = "With Icon",
                style = EkaButtonStyle.OUTLINED,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Search,
                    contentDescription = "Search"
                ),
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun EkaButtonTextPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EkaButton(
                label = "Text Button",
                style = EkaButtonStyle.TEXT,
                onClick = {}
            )
            EkaButton(
                label = "With Icon",
                style = EkaButtonStyle.TEXT,
                trailingIcon = EkaIcon(
                    icon = Icons.Default.ArrowForward,
                    contentDescription = "Arrow"
                ),
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun EkaButtonTonalPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EkaButton(
                label = "Tonal Button",
                style = EkaButtonStyle.TONAL,
                onClick = {}
            )
            EkaButton(
                label = "With Icons",
                style = EkaButtonStyle.TONAL,
                leadingIcon = com.eka.ui.buttons.EkaIcon(
                    icon = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                ),
                trailingIcon = com.eka.ui.buttons.EkaIcon(
                    icon = Icons.Default.ArrowForward,
                    contentDescription = "Arrow"
                ),
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun EkaButtonElevatedPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            EkaButton(
                label = "Elevated Button",
                style = EkaButtonStyle.ELEVATED,
                onClick = {}
            )
            EkaButton(
                label = "With Icon",
                style = EkaButtonStyle.ELEVATED,
                leadingIcon = EkaIcon(
                    icon = Icons.Default.Settings,
                    contentDescription = "Settings"
                ),
                onClick = {}
            )
        }
    }
}

// Size comparison preview
@Preview(showBackground = true, widthDp = 600)
@Composable
fun EkaButtonSizeComparisonPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Button Sizes",
                style = EkaTheme.typography.titleLarge
            )

            EkaButtonSize.entries.forEach { size ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = size.name,
                        style = EkaTheme.typography.labelMedium,
                        modifier = Modifier.width(80.dp)
                    )
                    EkaButton(
                        label = "Button",
                        size = size,
                        onClick = {}
                    )
                    EkaButton(
                        label = "Icon",
                        size = size,
                        leadingIcon = EkaIcon(
                            icon = Icons.Default.Add,
                            contentDescription = "Add"
                        ),
                        onClick = {}
                    )
                }
            }
        }
    }
}

// Shape comparison preview
@Preview(showBackground = true, widthDp = 400)
@Composable
fun EkaButtonShapeComparisonPreview() {
    EkaTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Button Shapes",
                style = EkaTheme.typography.titleLarge
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                EkaButton(
                    label = "Rounded",
                    shape = EkaButtonShape.ROUNDED,
                    onClick = {}
                )
                EkaButton(
                    label = "Square",
                    shape = EkaButtonShape.SQUARE,
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun HorizontalSpacer(space: Int) {
    Spacer(modifier = Modifier.width(space.dp))
}