package com.canerture.animatedtabrow

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedTabRowTitleAndIcon(
    selectedIndex: Int,
    tabData: TabType.TitleAndIcon,
    tabMode: TabMode,
    tabWidth: Dp,
    colors: AnimatedTabRowColors = AnimatedTabRowColors(),
    onTabClick: (Int) -> Unit,
) {
    if (tabMode == TabMode.SCROLLABLE) {
        LazyRow {
            itemsIndexed(tabData.list) { index, titleAndIcon ->
                val isSelected = selectedIndex == index
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(shape = CircleShape)
                        .background(
                            color = setBackgroundColorAnimation(
                                isSelected = isSelected,
                                containerColors = colors.containerColors
                            )
                        )
                        .padding(horizontal = 12.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null,
                            onClick = {
                                onTabClick(index)
                            }
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(if (isSelected || tabData.labelMode == LabelMode.ALWAYS_SHOW) 0.dp else 12.dp)
                            .size(size = tabData.iconSize),
                        imageVector = titleAndIcon.selectedIcon,
                        contentDescription = null,
                        tint = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                    )
                    if (tabData.labelMode == LabelMode.ALWAYS_SHOW) {
                        Text(
                            modifier = Modifier
                                .padding(start = 4.dp),
                            text = titleAndIcon.title,
                            fontSize = tabData.fontSize,
                            fontFamily = tabData.fontFamily,
                            color = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        AnimatedVisibility(visible = isSelected) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 4.dp),
                                text = titleAndIcon.title,
                                fontSize = tabData.fontSize,
                                fontFamily = tabData.fontFamily,
                                color = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
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
            verticalAlignment = Alignment.CenterVertically,
        ) {
            tabData.list.mapIndexed { index, titleAndIcon ->
                val isSelected = selectedIndex == index
                Row(
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
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        modifier = Modifier
                            .size(size = tabData.iconSize),
                        imageVector = titleAndIcon.selectedIcon,
                        contentDescription = null,
                        tint = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                    )
                    if (tabData.labelMode == LabelMode.ALWAYS_SHOW) {
                        Text(
                            modifier = Modifier
                                .padding(start = 4.dp),
                            text = titleAndIcon.title,
                            fontSize = tabData.fontSize,
                            fontFamily = tabData.fontFamily,
                            color = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                            textAlign = TextAlign.Center,
                        )
                    } else {
                        AnimatedVisibility(visible = isSelected) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 4.dp),
                                text = titleAndIcon.title,
                                fontSize = tabData.fontSize,
                                fontFamily = tabData.fontFamily,
                                color = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }

                if (index != tabData.list.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}