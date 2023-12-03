package com.canerture.animatedtabrow

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@Composable
private fun setAlphaAnimation(index: Int, selectedIndex: Int, duration: Int, active: Float, inactive: Float) =
    animateFloatAsState(
        targetValue = if (selectedIndex == index) active else inactive,
        animationSpec = tween(durationMillis = duration),
        label = ""
    ).value

@Composable
private fun setScaleAnimation(index: Int, selectedIndex: Int, duration: Int, active: Float, inactive: Float) =
    animateFloatAsState(
        targetValue = if (selectedIndex == index) active else inactive,
        animationSpec = tween(durationMillis = duration),
        label = ""
    ).value

@Composable
private fun setSizeAnimation(index: Int, selectedIndex: Int, duration: Int, active: Dp, inactive: Dp) =
    animateDpAsState(
        targetValue = if (selectedIndex == index) active else inactive,
        animationSpec = tween(durationMillis = duration),
        label = ""
    ).value

@Composable
fun setBackgroundColorAnimation(isSelected: Boolean, duration: Int = 300, containerColors: ContainerColorConfig) =
    animateColorAsState(
        targetValue = if (isSelected) containerColors.selectedColor else containerColors.unselectedColor,
        animationSpec = tween(durationMillis = duration, easing = FastOutSlowInEasing),
        label = ""
    ).value