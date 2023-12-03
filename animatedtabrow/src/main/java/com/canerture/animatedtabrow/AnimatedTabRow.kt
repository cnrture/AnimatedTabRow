package com.canerture.animatedtabrow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedTabRow(
    modifier: Modifier = Modifier,
    tabType: TabType,
    tabMode: TabMode,
    colors: AnimatedTabRowColors = AnimatedTabRowColors(),
    onTabClick: (Int) -> Unit,
) {
    BoxWithConstraints(
        modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(colors.backgroundColor)
    ) {

        val tabs = when (tabType) {
            is TabType.OnlyTitle -> tabType.list
            is TabType.OnlyIcon -> tabType.list
            is TabType.TitleAndIcon -> tabType.list
        }

        val tabWidth = this.maxWidth / tabs.size - (8.dp * (tabs.size - 1) / tabs.size)

        when (tabType) {
            is TabType.OnlyTitle -> {
                AnimatedTabRowOnlyText(
                    tabMode = tabMode,
                    tabData = tabType,
                    tabWidth = tabWidth,
                    colors = colors,
                    onTabClick = onTabClick
                )
            }

            is TabType.OnlyIcon -> {
                AnimatedTabRowOnlyIcon(
                    tabMode = tabMode,
                    selectedIndex = 0,
                    tabData = tabType,
                    tabWidth = tabWidth,
                    colors = colors,
                    onTabClick = onTabClick
                )
            }

            is TabType.TitleAndIcon -> {
                AnimatedTabRowTitleAndIcon(
                    tabMode = tabMode,
                    selectedIndex = 0,
                    tabData = tabType,
                    tabWidth = tabWidth,
                    colors = colors,
                    onTabClick = onTabClick
                )
            }
        }
    }
}
