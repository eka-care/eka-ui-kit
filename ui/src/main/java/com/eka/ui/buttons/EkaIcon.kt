package com.eka.ui.buttons

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@ConsistentCopyVisibility
data class EkaIcon private constructor(
    val imageVector: ImageVector?,
    val painterResource: Painter?,
    val contentDescription: String? = null
) {
    constructor(icon: ImageVector, contentDescription: String = "") : this(
        imageVector = icon,
        painterResource = null,
        contentDescription = contentDescription
    )

    constructor(icon: Painter, contentDescription: String = "") : this(
        imageVector = null,
        painterResource = icon,
        contentDescription = contentDescription
    )
}

