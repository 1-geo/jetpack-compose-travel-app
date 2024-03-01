package com.example.craneapp.ui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.craneapp.R
import com.example.craneapp.ui.theme.CraneTheme
import com.example.craneapp.ui.theme.crane_white

enum class CraneScreen {
    Fly,
    Sleep,
    Eat
}


@Composable
fun CraneTabRow(
    tabs: List<String>,
    selectedTab: String,
    tabChangedCallback: (CraneScreen) -> Unit,
    onMenuClicked: () -> Unit
) {
    Surface {
        Row{
            Row (
                modifier = Modifier
                    .padding(top = 8.dp)

            ) {
                Image(
                    modifier = Modifier.clickable { onMenuClicked() }.padding(top = 8.dp),
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_crane_logo),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            val selectedIndex = tabs.indexOf(selectedTab)
            TabRow(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                selectedTabIndex = selectedIndex,
                contentColor = MaterialTheme.colorScheme.onSurface,
                indicator = {},
                divider = {}
            ) {
                tabs.forEachIndexed { index, tab ->

                    Tab(
                        selected = index == selectedIndex,
                        onClick = { tabChangedCallback(CraneScreen.entries.first { it.name == tab }) }
                    ) {

                        var textModifier = Modifier
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                        if (selectedIndex == index) {
                            textModifier = Modifier
                                .border(BorderStroke(2.dp, crane_white), RoundedCornerShape(16.dp))
                                .then(textModifier)
                        }

                        Text(
                            modifier = textModifier,
                            text = tab.uppercase(),
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewCraneTabRow() {
    CraneTheme {
        CraneTabRow(
            tabs = CraneScreen.entries.map { it.name },
            selectedTab = CraneScreen.Fly.name,
            tabChangedCallback = {},
            onMenuClicked = {}
        )
    }
}