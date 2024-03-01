package com.example.craneapp.ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.craneapp.R
import com.example.craneapp.ui.theme.CraneTheme

val craneMenu = listOf("Find Trips", "My Trips", "Saved Trips", "Price Alerts", "My Account")

@Composable
fun CraneDrawer() {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, top = 44.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_crane_drawer),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(24.dp))
            craneMenu.forEach {
                Text(
                    text = it,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewCraneDrawer() {
    CraneTheme {
        CraneDrawer()
    }
}