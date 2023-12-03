package com.canerture.animatedtabrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.canerture.animatedtabrow.ui.theme.AnimatedTabRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedTabRowTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "AnimatedTabRow - Only Title",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        AnimatedTabRowOnlyTextFixed()
                        AnimatedTabRowOnlyTextScrollable()
                        Divider(modifier = Modifier.padding(top = 24.dp))

                        Text(
                            text = "AnimatedTabRow - Only Icon",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        AnimatedTabRowOnlyIconFixed()
                        AnimatedTabRowOnlyIconScrollable()
                        Divider(modifier = Modifier.padding(top = 24.dp))

                        Text(
                            text = "AnimatedTabRow - Title And Icon",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        AnimatedTabRowTitleAndIconFixedAlwaysShow()
                        AnimatedTabRowTitleAndIconFixedOnlySelected()
                        AnimatedTabRowTitleAndIconScrollableAlwaysShow()
                        AnimatedTabRowTitleAndIconScrollableOnlySelected()
                        Divider(modifier = Modifier.padding(top = 24.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun AnimatedTabRowOnlyTextFixed() {
    var selectedFixedIndex by remember {
        mutableStateOf(0)
    }

    val fixedItems = listOf(
        "Home",
        "Search",
        "Profile",
    )

    Text(text = "TabMode.FIXED")

    AnimatedTabRow(
        tabType = TabType.OnlyTitle(fixedItems, 14.sp),
        tabMode = TabMode.FIXED,
        onTabClick = {
            selectedFixedIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowOnlyTextScrollable() {
    var selectedScrollableIndex by remember {
        mutableStateOf(0)
    }

    val scrollableItems = remember {
        listOf(
            "Home",
            "Search",
            "Profile",
            "Settings",
            "About",
            "Contact",
        )
    }

    Text(text = "TabMode.SCROLLABLE")

    AnimatedTabRow(
        tabType = TabType.OnlyTitle(scrollableItems, 14.sp),
        tabMode = TabMode.SCROLLABLE,
        onTabClick = {
            selectedScrollableIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowOnlyIconFixed() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val items = remember {
        listOf(
            Icons.Filled.Home,
            Icons.Filled.Search,
            Icons.Filled.Person
        )
    }

    Text(text = "TabMode.FIXED")

    AnimatedTabRow(
        tabType = TabType.OnlyIcon(items, 24.dp),
        tabMode = TabMode.FIXED,
        onTabClick = {
            selectedIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowOnlyIconScrollable() {
    var selectedScrollableIndex by remember {
        mutableStateOf(0)
    }

    val scrollableItems = remember {
        listOf(
            Icons.Filled.Home,
            Icons.Filled.Search,
            Icons.Filled.Person,
            Icons.Filled.Settings,
            Icons.Filled.Info,
            Icons.Filled.Call,
            Icons.Filled.Favorite,
        )
    }

    Text(text = "TabMode.SCROLLABLE")

    AnimatedTabRow(
        tabType = TabType.OnlyIcon(scrollableItems),
        tabMode = TabMode.SCROLLABLE,
        onTabClick = {
            selectedScrollableIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowTitleAndIconFixedAlwaysShow() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val items = remember {
        listOf(
            TitleAndIconData(
                title = "Home",
                selectedIcon = Icons.Filled.Home
            ),
            TitleAndIconData(
                title = "Search",
                selectedIcon = Icons.Filled.Search
            ),
            TitleAndIconData(
                title = "Profile",
                selectedIcon = Icons.Filled.Person
            )
        )
    }

    Text(text = "TabMode.FIXED")

    AnimatedTabRow(
        tabType = TabType.TitleAndIcon(
            list = items,
            labelMode = LabelMode.ALWAYS_SHOW,
        ),
        tabMode = TabMode.FIXED,
        onTabClick = {
            selectedIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowTitleAndIconFixedOnlySelected() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    val items = remember {
        listOf(
            TitleAndIconData(
                title = "Home",
                selectedIcon = Icons.Filled.Home
            ),
            TitleAndIconData(
                title = "Search",
                selectedIcon = Icons.Filled.Search
            ),
            TitleAndIconData(
                title = "Profile",
                selectedIcon = Icons.Filled.Person
            )
        )
    }

    Text(text = "TabMode.FIXED")

    AnimatedTabRow(
        tabType = TabType.TitleAndIcon(
            list = items,
            labelMode = LabelMode.ONLY_SELECTED,
        ),
        tabMode = TabMode.FIXED,
        onTabClick = {
            selectedIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowTitleAndIconScrollableAlwaysShow() {
    var selectedScrollableIndex by remember {
        mutableStateOf(0)
    }

    val scrollableItems = remember {
        listOf(
            TitleAndIconData(
                title = "Home",
                selectedIcon = Icons.Filled.Home
            ),
            TitleAndIconData(
                title = "Search",
                selectedIcon = Icons.Filled.Search
            ),
            TitleAndIconData(
                title = "Profile",
                selectedIcon = Icons.Filled.Person
            ),
            TitleAndIconData(
                title = "Settings",
                selectedIcon = Icons.Filled.Settings
            ),
            TitleAndIconData(
                title = "About",
                selectedIcon = Icons.Filled.Info
            ),
            TitleAndIconData(
                title = "Contact",
                selectedIcon = Icons.Filled.Call
            ),
            TitleAndIconData(
                title = "Favorite",
                selectedIcon = Icons.Filled.Favorite
            ),
        )
    }

    Text(text = "TabMode.SCROLLABLE")

    AnimatedTabRow(
        tabType = TabType.TitleAndIcon(scrollableItems, LabelMode.ALWAYS_SHOW),
        tabMode = TabMode.SCROLLABLE,
        onTabClick = {
            selectedScrollableIndex = it
        }
    )
}

@Composable
fun AnimatedTabRowTitleAndIconScrollableOnlySelected() {
    var selectedScrollableIndex by remember {
        mutableStateOf(0)
    }

    val scrollableItems = remember {
        listOf(
            TitleAndIconData(
                title = "Home",
                selectedIcon = Icons.Filled.Home
            ),
            TitleAndIconData(
                title = "Search",
                selectedIcon = Icons.Filled.Search
            ),
            TitleAndIconData(
                title = "Profile",
                selectedIcon = Icons.Filled.Person
            ),
            TitleAndIconData(
                title = "Settings",
                selectedIcon = Icons.Filled.Settings
            ),
            TitleAndIconData(
                title = "About",
                selectedIcon = Icons.Filled.Info
            ),
            TitleAndIconData(
                title = "Contact",
                selectedIcon = Icons.Filled.Call
            ),
            TitleAndIconData(
                title = "Favorite",
                selectedIcon = Icons.Filled.Favorite
            ),
        )
    }

    Text(text = "TabMode.SCROLLABLE")

    AnimatedTabRow(
        tabType = TabType.TitleAndIcon(scrollableItems, LabelMode.ONLY_SELECTED),
        tabMode = TabMode.SCROLLABLE,
        onTabClick = {
            selectedScrollableIndex = it
        }
    )
}
