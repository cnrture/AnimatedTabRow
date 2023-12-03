package com.canerture.animatedtabrow

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedTabRowOnlyText(
    tabData: TabType.OnlyTitle,
    tabMode: TabMode,
    tabWidth: Dp,
    colors: AnimatedTabRowColors = AnimatedTabRowColors(),
    onTabClick: (Int) -> Unit,
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val backgroundColor = animateColorAsState(
        targetValue = if (isSelected) colors.containerColors.selectedColor else colors.containerColors.unselectedColor,
        animationSpec = tween(durationMillis = 750, easing = FastOutSlowInEasing),
        label = ""
    )

    if (tabMode == TabMode.SCROLLABLE) {
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
        ) {
            tabData.list.forEachIndexed { index, title ->
                val isSelected = selectedIndex == index
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(shape = CircleShape)
                        .background(
                            color = backgroundColor.value
                        )
                        .clickable(
                            //interactionSource = remember { MutableInteractionSource() },
                            //indication = null,
                            onClick = {
                                onTabClick(index)
                                selectedIndex = index
                            }
                        )
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = 16.dp),
                        text = title,
                        fontSize = tabData.fontSize,
                        fontFamily = tabData.fontFamily,
                        color = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                        textAlign = TextAlign.Center,
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
            tabData.list.mapIndexed { index, title ->
                val isSelected = selectedIndex == index
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(width = tabWidth)
                        .clip(shape = CircleShape)
                        .background(
                            color = backgroundColor.value
                        )
                        .clickable(
                            //interactionSource = remember { MutableInteractionSource() },
                            //indication = null,
                            onClick = {
                                onTabClick(index)
                                selectedIndex = index
                            }
                        )
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(horizontal = 16.dp),
                        text = title,
                        fontSize = tabData.fontSize,
                        fontFamily = tabData.fontFamily,
                        color = if (isSelected) colors.contentColors.selectedColor else colors.contentColors.unselectedColor,
                        textAlign = TextAlign.Center,
                    )
                }

                if (index != tabData.list.lastIndex) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}