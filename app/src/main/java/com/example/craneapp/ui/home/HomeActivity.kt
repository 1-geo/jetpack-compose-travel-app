package com.example.craneapp.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
//import com.example.craneapp.ui.details.launchDetailsActivity
import com.example.craneapp.ui.theme.CraneTheme

class HomeActivity: ComponentActivity() {
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        setContent {
            CraneTheme {
                var showLanding by remember {
                    mutableStateOf(true)
                }

                if (showLanding) {
                    CraneLandingScreen {
                        showLanding = false
                    }
                }
                else {
                    CraneHome(
                        homeViewModel = viewModel,
                        exploreCallback = {
                            // navigate
                            /*launchDetailsActivity(
                                context = this,
                                item = it
                            )*/
                        }
                    )
                }
            }
        }
    }
}