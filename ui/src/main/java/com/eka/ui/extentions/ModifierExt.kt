package com.eka.ui.extentions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun Modifier.clickableWithoutRipple(
    onClick: () -> Unit,
    enabled: Boolean = true
): Modifier = composed {
    clickable(
        enabled = enabled,
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

