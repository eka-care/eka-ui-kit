import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eka.ui.buttons.EkaButton
import com.eka.ui.buttons.EkaButtonShape
import com.eka.ui.buttons.EkaButtonSize
import com.eka.ui.buttons.EkaButtonStyle
import com.eka.ui.buttons.EkaIcon
import com.eka.ui.theme.EkaTheme

@Preview(showBackground = true, widthDp = 1400, heightDp = 3000)
@Composable
fun EkaButtonGroupsPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF8F9FA)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            // Title
            Text(
                text = "Button groups",
                style = EkaTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "See design guidelines",
                style = EkaTheme.typography.bodyMedium,
                color = EkaTheme.colors.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Simple Button Groups
            SimpleButtonGroups()

            Spacer(modifier = Modifier.height(16.dp))

            // Icon Button Groups
            IconButtonGroups()

            Spacer(modifier = Modifier.height(16.dp))

            // Segmented Button Groups
            SegmentedButtonGroups()

            Spacer(modifier = Modifier.height(16.dp))

            // Toggle Button Groups
            ToggleButtonGroups()

            Spacer(modifier = Modifier.height(16.dp))

            // Mixed Button Groups
            MixedButtonGroups()

            Spacer(modifier = Modifier.height(16.dp))

            // Size Variations
            SizeVariationGroups()

            Spacer(modifier = Modifier.height(16.dp))

            // Pagination Groups
            PaginationGroups()
        }
    }
}

@Composable
private fun SimpleButtonGroups() {
    GroupSection(title = "Simple Button Groups") {
        // Basic horizontal group
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(label = "First", onClick = {})
            EkaButton(label = "Second", onClick = {})
            EkaButton(label = "Third", onClick = {})
        }

        // Outlined group
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(label = "Option 1", style = EkaButtonStyle.OUTLINED, onClick = {})
            EkaButton(label = "Option 2", style = EkaButtonStyle.OUTLINED, onClick = {})
            EkaButton(label = "Option 3", style = EkaButtonStyle.OUTLINED, onClick = {})
        }

        // Text button group
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(label = "Save", style = EkaButtonStyle.TEXT, onClick = {})
            EkaButton(label = "Cancel", style = EkaButtonStyle.TEXT, onClick = {})
            EkaButton(label = "Delete", style = EkaButtonStyle.TEXT, onClick = {})
        }

        // Tonal button group
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(label = "Today", style = EkaButtonStyle.TONAL, onClick = {})
            EkaButton(label = "Week", style = EkaButtonStyle.TONAL, onClick = {})
            EkaButton(label = "Month", style = EkaButtonStyle.TONAL, onClick = {})
            EkaButton(label = "Year", style = EkaButtonStyle.TONAL, onClick = {})
        }
    }
}

@Composable
private fun IconButtonGroups() {
    GroupSection(title = "Icon Button Groups") {
        // Leading icon group
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(
                label = "Upload",
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "Download",
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "Share",
                leadingIcon = EkaIcon(Icons.Default.Share),
                onClick = {}
            )
        }

        // Icon only buttons (using small size)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(
                label = "",
                size = EkaButtonSize.SMALL,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "",
                size = EkaButtonSize.SMALL,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "",
                size = EkaButtonSize.SMALL,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "",
                size = EkaButtonSize.SMALL,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
        }

        // Mixed icon and text
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(
                label = "Previous",
                leadingIcon = EkaIcon(Icons.Default.ArrowBack),
                style = EkaButtonStyle.OUTLINED,
                onClick = {}
            )
            EkaButton(
                label = "Next",
                trailingIcon = EkaIcon(Icons.Default.ArrowForward),
                style = EkaButtonStyle.OUTLINED,
                onClick = {}
            )
        }
    }
}

@Composable
private fun SegmentedButtonGroups() {
    GroupSection(title = "Segmented Button Groups") {
        // View mode selector
        var selectedView by remember { mutableStateOf(0) }
        Row(horizontalArrangement = Arrangement.spacedBy(0.dp)) {
            EkaButton(
                label = "List",
                style = if (selectedView == 0) EkaButtonStyle.FILLED else EkaButtonStyle.OUTLINED,
                shape = EkaButtonShape.SQUARE,
                leadingIcon = EkaIcon(Icons.Default.List),
                onClick = { selectedView = 0 }
            )
            EkaButton(
                label = "Grid",
                style = if (selectedView == 1) EkaButtonStyle.FILLED else EkaButtonStyle.OUTLINED,
                shape = EkaButtonShape.SQUARE,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = { selectedView = 1 }
            )
            EkaButton(
                label = "Calendar",
                style = if (selectedView == 2) EkaButtonStyle.FILLED else EkaButtonStyle.OUTLINED,
                shape = EkaButtonShape.SQUARE,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = { selectedView = 2 }
            )
        }

        // Time period selector
        var selectedPeriod by remember { mutableStateOf(1) }
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            listOf("Day", "Week", "Month", "Year").forEachIndexed { index, label ->
                EkaButton(
                    label = label,
                    style = if (selectedPeriod == index) EkaButtonStyle.TONAL else EkaButtonStyle.TEXT,
                    size = EkaButtonSize.SMALL,
                    onClick = { selectedPeriod = index }
                )
            }
        }
    }
}

@Composable
private fun ToggleButtonGroups() {
    GroupSection(title = "Toggle Button Groups") {
        // Multiple selection
        val selectedOptions = remember { mutableStateListOf(0, 2) }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Bold", "Italic", "Underline", "Strike").forEachIndexed { index, label ->
                val isSelected = selectedOptions.contains(index)
                EkaButton(
                    label = label,
                    style = if (isSelected) EkaButtonStyle.FILLED else EkaButtonStyle.OUTLINED,
                    size = EkaButtonSize.SMALL,
                    onClick = {
                        if (isSelected) selectedOptions.remove(index)
                        else selectedOptions.add(index)
                    }
                )
            }
        }

        // Settings toggles
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            var notifications by remember { mutableStateOf(true) }
            var darkMode by remember { mutableStateOf(false) }

            EkaButton(
                label = if (notifications) "Notifications ON" else "Notifications OFF",
                style = if (notifications) EkaButtonStyle.TONAL else EkaButtonStyle.OUTLINED,
                leadingIcon = EkaIcon(
                    if (notifications) Icons.Default.Notifications
                    else Icons.Default.Done
                ),
                onClick = { notifications = !notifications }
            )

            EkaButton(
                label = if (darkMode) "Dark Mode" else "Light Mode",
                style = if (darkMode) EkaButtonStyle.FILLED else EkaButtonStyle.OUTLINED,
                leadingIcon = EkaIcon(
                    if (darkMode) Icons.Default.Done
                    else Icons.Default.Done
                ),
                onClick = { darkMode = !darkMode }
            )
        }
    }
}

@Composable
private fun MixedButtonGroups() {
    GroupSection(title = "Mixed Button Groups") {
        // Primary + Secondary actions
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(
                label = "Save Changes",
                style = EkaButtonStyle.FILLED,
                leadingIcon = EkaIcon(Icons.Default.Check),
                onClick = {}
            )
            EkaButton(
                label = "Cancel",
                style = EkaButtonStyle.OUTLINED,
                onClick = {}
            )
            EkaButton(
                label = "Delete",
                style = EkaButtonStyle.TEXT,
                leadingIcon = EkaIcon(Icons.Default.Delete),
                onClick = {}
            )
        }

        // Action toolbar
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(
                label = "Create New",
                style = EkaButtonStyle.FILLED,
                leadingIcon = EkaIcon(Icons.Default.Add),
                onClick = {}
            )
            EkaButton(
                label = "Import",
                style = EkaButtonStyle.TONAL,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "Export",
                style = EkaButtonStyle.TONAL,
                leadingIcon = EkaIcon(Icons.Default.Done),
                onClick = {}
            )
            EkaButton(
                label = "Settings",
                style = EkaButtonStyle.TEXT,
                leadingIcon = EkaIcon(Icons.Default.Settings),
                onClick = {}
            )
        }
    }
}

@Composable
private fun SizeVariationGroups() {
    GroupSection(title = "Size Variations") {
        // Extra Small group
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            EkaButton(label = "XS", size = EkaButtonSize.XSMALL, onClick = {})
            EkaButton(
                label = "XS",
                size = EkaButtonSize.XSMALL,
                style = EkaButtonStyle.OUTLINED,
                onClick = {})
            EkaButton(
                label = "XS",
                size = EkaButtonSize.XSMALL,
                style = EkaButtonStyle.TONAL,
                onClick = {})
        }

        // Small group
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(label = "Small", size = EkaButtonSize.SMALL, onClick = {})
            EkaButton(
                label = "Small",
                size = EkaButtonSize.SMALL,
                style = EkaButtonStyle.OUTLINED,
                onClick = {})
            EkaButton(
                label = "Small",
                size = EkaButtonSize.SMALL,
                style = EkaButtonStyle.TONAL,
                onClick = {})
        }

        // Medium group (default)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            EkaButton(label = "Medium", onClick = {})
            EkaButton(label = "Medium", style = EkaButtonStyle.OUTLINED, onClick = {})
            EkaButton(label = "Medium", style = EkaButtonStyle.TONAL, onClick = {})
        }

        // Large group
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            EkaButton(label = "Large", size = EkaButtonSize.LARGE, onClick = {})
            EkaButton(
                label = "Large",
                size = EkaButtonSize.LARGE,
                style = EkaButtonStyle.OUTLINED,
                onClick = {})
        }

        // Extra Large group
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            EkaButton(label = "Extra Large", size = EkaButtonSize.XLARGE, onClick = {})
        }
    }
}

@Composable
private fun PaginationGroups() {
    GroupSection(title = "Pagination Groups") {
        // Simple pagination
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            EkaButton(
                label = "",
                size = EkaButtonSize.SMALL,
                style = EkaButtonStyle.TEXT,
                leadingIcon = EkaIcon(Icons.Default.ArrowBack),
                onClick = {}
            )
            (1..5).forEach { page ->
                EkaButton(
                    label = "$page",
                    size = EkaButtonSize.SMALL,
                    style = if (page == 2) EkaButtonStyle.FILLED else EkaButtonStyle.TEXT,
                    onClick = {}
                )
            }
            EkaButton(
                label = "...",
                size = EkaButtonSize.SMALL,
                style = EkaButtonStyle.TEXT,
                enabled = false,
                onClick = {}
            )
            EkaButton(
                label = "10",
                size = EkaButtonSize.SMALL,
                style = EkaButtonStyle.TEXT,
                onClick = {}
            )
            EkaButton(
                label = "",
                size = EkaButtonSize.SMALL,
                style = EkaButtonStyle.TEXT,
                leadingIcon = EkaIcon(Icons.Default.ArrowForward),
                onClick = {}
            )
        }

        // Compact pagination
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            EkaButton(
                label = "Previous",
                style = EkaButtonStyle.OUTLINED,
                size = EkaButtonSize.SMALL,
                leadingIcon = EkaIcon(Icons.Default.ArrowBack),
                onClick = {}
            )
            Text(
                text = "Page 3 of 10",
                style = EkaTheme.typography.bodyMedium
            )
            EkaButton(
                label = "Next",
                style = EkaButtonStyle.OUTLINED,
                size = EkaButtonSize.SMALL,
                trailingIcon = EkaIcon(Icons.Default.ArrowForward),
                onClick = {}
            )
        }
    }
}

@Composable
private fun GroupSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            style = EkaTheme.typography.titleLarge,
            fontWeight = FontWeight.Medium,
            color = EkaTheme.colors.onSurface
        )
        content()
    }
}

@Composable
fun HorizontalSpacer(space: Int) {
    Spacer(modifier = Modifier.width(space.dp))
}