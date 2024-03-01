package com.example.craneapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.craneapp.R
import com.example.craneapp.ui.theme.CraneTheme


@Composable
fun CraneFlySearch() {
    CraneSearch {
        PeopleUserInput("Economy", {})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_location, null, "Seoul, South Korea", isHint = false, onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        DestinationInput({})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_calendar, null, "Select Dates", isHint = true, onClick = {})
    }
}

@Composable
fun CraneSleepSearch() {
    CraneSearch {
        PeopleUserInput("", {})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_calendar, null, "Select Dates", isHint = true, onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_hotel, null, "Select Location", isHint = true, onClick = {})
    }
}

@Composable
fun CraneEatSearch() {
    CraneSearch {
        PeopleUserInput("", {})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_calendar, null, "Select Dates", isHint = true, onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_time, null, "Select Time", isHint = true, onClick = {})
        Spacer(modifier = Modifier.height(8.dp))
        SimpleUserInput(R.drawable.ic_restaurant, null, "Select Location", isHint = true, onClick = {})
    }
}

@Composable
fun CraneSearch(content: @Composable () -> Unit) {
    Column(
        Modifier.padding(start = 24.dp, end = 24.dp, top = 0.dp, bottom = 12.dp)
    ) {
        content()
    }
}

/**
 * Previews
 */
@Preview
@Composable
fun PreviewCraneFlySearch() {
    CraneTheme {
        CraneFlySearch()
    }
}

@Preview
@Composable
fun PreviewCraneSleepSearch() {
    CraneTheme {
        CraneSleepSearch()
    }
}

@Preview
@Composable
fun PreviewCraneEatSearch() {
    CraneTheme {
        CraneEatSearch()
    }
}