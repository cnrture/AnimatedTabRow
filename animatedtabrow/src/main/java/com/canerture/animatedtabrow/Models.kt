package com.canerture.animatedtabrow

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

enum class TabMode {
    FIXED,
    SCROLLABLE
}

enum class LabelMode {
    ALWAYS_SHOW,
    ONLY_SELECTED
}

sealed class TabType {
    data class OnlyTitle(
        val list: List<String>,
        val fontSize: TextUnit = TextUnit.Unspecified,
        val fontFamily: FontFamily? = null
    ) : TabType()

    data class OnlyIcon(
        val list: List<ImageVector>,
        val iconSize: Dp = 24.dp,
    ) : TabType()

    data class TitleAndIcon(
        val list: List<TitleAndIconData>,
        val labelMode: LabelMode,
        val fontSize: TextUnit = TextUnit.Unspecified,
        val fontFamily: FontFamily? = null,
        val iconSize: Dp = 24.dp,
    ) : TabType()
}

data class TitleAndIconData(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector? = null
)

data class AnimatedTabRowColors(
    val backgroundColor: Color = Color.Transparent,
    val containerColors: ContainerColorConfig = ContainerColorConfig(),
    val contentColors: ContentColorConfig = ContentColorConfig(),
)

data class ContainerColorConfig(
    val selectedColor: Color = Color.Black.copy(alpha = 0.7f),
    val unselectedColor: Color = Color.Gray.copy(alpha = 0.2f),
)

data class ContentColorConfig(
    val selectedColor: Color = Color.White,
    val unselectedColor: Color = Color.Black.copy(alpha = 0.7f),
)