package com.eka.ui.fab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eka.ui.theme.EkaTheme
import com.eka.ui.theme.darkScheme

@Composable
fun EkaFloatingActionButton(
    fabType: FabType = FabType.NORMAL,
    fabColor: FabColor = FabColor.PRIMARY,
    actionText: String? = null,
    icon: (@Composable () -> Unit)? = null,
    onClick: () -> Unit,
) {
    val containerColor = when (fabColor) {
        FabColor.PRIMARY -> EkaTheme.colors.primary
        FabColor.SECONDARY -> EkaTheme.colors.secondary
        FabColor.TERTIARY -> EkaTheme.colors.tertiary
        FabColor.PRIMARY_CONTAINER -> EkaTheme.colors.primaryContainer
        FabColor.SECONDARY_CONTAINER -> EkaTheme.colors.secondaryContainer
        FabColor.TERTIARY_CONTAINER -> EkaTheme.colors.tertiaryContainer
    }

    val fabSize = when (fabType) {
        FabType.NORMAL -> 56.dp
        FabType.MEDIUM -> 80.dp
        FabType.LARGE -> 96.dp
    }

    val textColor = when (fabColor) {
        FabColor.PRIMARY -> EkaTheme.colors.onPrimary
        FabColor.SECONDARY -> EkaTheme.colors.onSecondary
        FabColor.TERTIARY -> EkaTheme.colors.onTertiary
        FabColor.PRIMARY_CONTAINER -> EkaTheme.colors.onPrimaryContainer
        FabColor.SECONDARY_CONTAINER -> EkaTheme.colors.onSecondaryContainer
        FabColor.TERTIARY_CONTAINER -> EkaTheme.colors.onTertiaryContainer
    }

    val fontStyle = when(fabType) {
        FabType.NORMAL -> EkaTheme.typography.titleMedium
        FabType.MEDIUM -> EkaTheme.typography.titleLarge
        FabType.LARGE -> EkaTheme.typography.headlineSmall
    }

    if (actionText != null) {
        ExtendedFloatingActionButton(
            modifier = Modifier.height(fabSize),
            containerColor = containerColor,
            onClick = onClick
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                icon?.invoke()
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = actionText,
                    style = fontStyle,
                    color = textColor
                )
            }
        }
    } else {
        FloatingActionButton(
            modifier = Modifier.size(fabSize),
            containerColor = containerColor,
            onClick = onClick,
            content = icon ?: {}
        )
    }
}

@Composable
@Preview
private fun NormalFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun MediumFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.MEDIUM,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun LargeFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.LARGE,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun NormalSecondaryFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        fabColor = FabColor.SECONDARY,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun MediumSecondaryFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.MEDIUM,
        fabColor = FabColor.SECONDARY,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun LargeSecondaryFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.LARGE,
        fabColor = FabColor.SECONDARY,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun NormalTertiaryFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        fabColor = FabColor.TERTIARY,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun MediumTertiaryFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.MEDIUM,
        fabColor = FabColor.TERTIARY,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun LargeTertiaryFabPreview() {
    EkaFloatingActionButton(
        fabType = FabType.LARGE,
        fabColor = FabColor.TERTIARY,
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun NormalFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun MediumFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.MEDIUM,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun LargeFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.LARGE,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun NormalSecondaryFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        fabColor = FabColor.SECONDARY,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun MediumSecondaryFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.MEDIUM,
        fabColor = FabColor.SECONDARY,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun LargeSecondaryFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.LARGE,
        fabColor = FabColor.SECONDARY,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun NormalTertiaryFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        fabColor = FabColor.TERTIARY,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun MediumTertiaryFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.MEDIUM,
        fabColor = FabColor.TERTIARY,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun LargeTertiaryFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.LARGE,
        fabColor = FabColor.TERTIARY,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}

@Composable
@Preview
private fun NormalSecondaryContainerFabTextPreview() {
    EkaFloatingActionButton(
        fabType = FabType.NORMAL,
        fabColor = FabColor.SECONDARY_CONTAINER,
        actionText = "Add Item",
        icon = {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = Icons.Default.Add,
                contentDescription = "Add Icon",
                tint = EkaTheme.colors.onPrimary
            )
        },
        onClick = {}
    )
}