package com.example.craneapp.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.graphics.Color
import com.example.craneapp.R
import com.example.craneapp.ui.base.BaseUserInput
import com.example.craneapp.ui.base.EditableUserInput
import com.example.craneapp.ui.base.rememberSaveableEditUserInputState
import com.example.craneapp.ui.theme.captionTextStyle
import com.example.craneapp.ui.theme.crane_white
import kotlinx.coroutines.flow.filter

@Composable
fun SimpleUserInput(
    @DrawableRes vectorId: Int,
    caption: String? = null,
    text: String,
    isHint: Boolean,
    onClick: () -> Unit
) {
    BaseUserInput(
        vectorId = vectorId,
        onClick = onClick,
        caption = caption,
        content = {
            Text(
                text = text,
                style = if (isHint) captionTextStyle.copy(color = crane_white) else
                    MaterialTheme.typography.bodyLarge.copy(color = crane_white)
            )
        }
    )
}

private const val MAX_PEOPLE = 4

// better way to use State Holder, and hoists it within the callee
@Composable
fun PeopleUserInput(
    suffix: String = "",
    peopleChangedCallback: (Int) -> Unit
) {
    var peopleCount by remember { mutableStateOf(1) }

    Column {
        BaseUserInput(
            vectorId = R.drawable.ic_person,
            onClick = {
                if (peopleCount > MAX_PEOPLE)
                    peopleCount = 1
                else
                    peopleCount++
                peopleChangedCallback(peopleCount)
            },
            content = {
                Text(
                    text = if (peopleCount == 0) "$peopleCount Adult, $suffix" else "$peopleCount Adults, $suffix",
                    style = MaterialTheme.typography.bodyLarge.copy(color = crane_white)
                )
            }
        )

        if (peopleCount > MAX_PEOPLE) {
            Text(
                text = "Error max of 4 people supported",
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Red)
            )
        }
    }
}

// using State Holder, and hoisted within the callee
@Composable
fun DestinationInput(onToDestinationChanged: (String) -> Unit) {
    // Note: To make this UI Control Component more flexible, testable and controllable from outside use State Holder.
    // - create a state that contains test with State. implements the Saver using listSaver, mapSaver.
    // - remember this State across rotations using rememberSaveable
    // - the control composable takes the state as input.
    // - the calling Composable hoists the State and makes this more flexible to be reused across app!
    val editInputState =
        rememberSaveableEditUserInputState(hintText = "Choose Destination", initialText = "Choose Destination")

    EditableUserInput(
        inputState = editInputState,
        vector = R.drawable.ic_plane,
        caption = "To",
        onClick = {}
    )

    // run a side a effect to update callback on text change
    // with this impl we need to callback into VM use rememberUpdatedState + LaunchedEffect.
    // LaunchedEffect on editableUserInputState, since this is rememberSaveable it shouldnt change
    // snapshotFlow converts State into Kotlin Flow, here we filter also
    val latestOnDestinationChanged by rememberUpdatedState(newValue = onToDestinationChanged)
    LaunchedEffect(key1 = editInputState) {
        snapshotFlow { editInputState.textState }
            .filter { !editInputState.isHint() }
            .collect {
                latestOnDestinationChanged(it)
            }
    }
}