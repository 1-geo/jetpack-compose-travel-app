package com.example.craneapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.craneapp.R
import com.example.craneapp.ui.theme.crane_purple_800
import kotlinx.coroutines.delay

@Composable
fun CraneLandingScreen(
    timeoutCallback: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(crane_purple_800),
        contentAlignment = Alignment.Center
    ) {

        // Note: You should use rememberUpdatedState when a long-lived lambda or object expression
        // references parameters or values computed during composition, which might be common
        // when working with LaunchedEffect.
        // This will always refer to the latest onTimeout function that
        // LandingScreen was recomposed with
        val updatedCallback by rememberUpdatedState(newValue = timeoutCallback)


        // Create an LaunchedEffect that matches the lifecycle of LandingScreen.
        // If LandingScreen recomposes or onTimeout changes,
        // the delay shouldn't start again.
        LaunchedEffect(Unit) {
            delay(2000)
            updatedCallback()
        }

        Image(
            painter = painterResource(id = R.drawable.ic_crane_logo),
            contentDescription = null
        )
    }
}