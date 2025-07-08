package com.eka.ui.buttons

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@ConsistentCopyVisibility
data class EkaIcon private constructor(
    val imageVector: ImageVector?,
    val painterResource: Painter?
) {
    constructor(icon: ImageVector) : this(imageVector = icon, painterResource = null)

    constructor(icon: Painter) : this(imageVector = null, painterResource = icon)
}

