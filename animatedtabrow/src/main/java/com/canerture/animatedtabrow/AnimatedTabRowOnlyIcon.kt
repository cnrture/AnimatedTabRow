package com.canerture.animatedtabrow

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedTabRowOnlyIcon(
    selectedIndex: Int,
    tabData: TabType.OnlyIcon,
    tabMode: TabMode,
    tabWidth: Dp,
    colors: AnimatedTabRowColors = AnimatedTabRowColors(),
    onTabClick: (Int) -> Unit,
) {
    if (tabMode == TabMode.SCROLLABLE) {
        LazyRow {
            itemsIndexed(tabData.list) { index, icon ->
                val isSelected = selectedIndex == index
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(shape = CircleShape)
                        .background(
                            color = setBackgroundColorAnimation(
                                isSelected = isSelected,
                                containerColors = colors.containerColors
                            )
                        )
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                onTabClick(index)
                            }
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(12.dp)
                            .size(size = tabData.iconSize),
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                    )
                }

                if (index != tabData.list.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    } else {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            tabData.list.mapIndexed { index, icon ->
                val isSelected = selectedIndex == index
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width = tabWidth)
                        .clip(shape = CircleShape)
                        .background(
                            color = setBackgroundColorAnimation(
                                isSelected = isSelected,
                                containerColors = colors.containerColors
                            )
                        )
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                onTabClick(index)
                            }
                        )
                ) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(size = tabData.iconSize),
                        imageVector = icon,
                        contentDescription = null,
                        tint = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                    )
                }

                if (index != tabData.list.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}