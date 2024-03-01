package com.example.craneapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.samples.crane.data.ExploreModel
import androidx.compose.ui.Modifier
import com.example.craneapp.ui.base.CraneDrawer
import com.example.craneapp.ui.base.CraneScreen
import com.example.craneapp.ui.base.CraneTabRow
import kotlinx.coroutines.launch

@Composable
fun CraneHome(
    homeViewModel: HomeViewModel,
    exploreCallback: (ExploreModel) -> Unit
) {
    // modal navigation drawer
    val drawerSate = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            CraneDrawer()
        },
        drawerState = drawerSate
    ) {
        val coroutineScope = rememberCoroutineScope()
        var selectedTab by remember { mutableStateOf(CraneScreen.Fly) }
        Scaffold { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {

                // custom tab row
                CraneTabRow(
                    tabs = CraneScreen.entries.map { it.name },
                    selectedTab = selectedTab.name,
                    tabChangedCallback = {
                        selectedTab = it
                    },
                    onMenuClicked = {
                        coroutineScope.launch { drawerSate.open() }
                    }
                )

                // search controls
                Surface {
                    when (selectedTab) {
                        CraneScreen.Fly -> {
                            CraneFlySearch()
                        }
                        CraneScreen.Eat -> {
                            CraneEatSearch()
                        }
                        CraneScreen.Sleep -> {
                            CraneSleepSearch()
                        }
                    }
                }

                // display lists
                when (selectedTab) {
                    CraneScreen.Fly -> {
                        ExploreSection(
                            headline = "Explore Flights by Destination",
                            list = homeViewModel.destinations,
                            clickCallback = exploreCallback
                        )
                    }
                    CraneScreen.Eat -> {
                        ExploreSection(
                            headline = "Explore Properties by Destination",
                            list = homeViewModel.hotels,
                            clickCallback = exploreCallback
                        )
                    }
                    CraneScreen.Sleep -> {
                        ExploreSection(
                            headline = "Explore Restaurants by Destination",
                            list = homeViewModel.restaurants,
                            clickCallback = exploreCallback
                        )
                    }
                }
            }
        }
    }
}