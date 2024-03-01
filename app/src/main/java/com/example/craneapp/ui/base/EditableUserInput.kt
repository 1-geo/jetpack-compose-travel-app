package com.example.craneapp.ui.base

import androidx.annotation.DrawableRes
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import com.example.craneapp.R
import com.example.craneapp.ui.theme.CraneTheme
import com.example.craneapp.ui.theme.captionTextStyle
import com.example.craneapp.ui.theme.crane_purple_700
import com.example.craneapp.ui.theme.crane_purple_800
import com.example.craneapp.ui.theme.crane_white

/**
 * State Holder
 */
class EditUserInputState(val hintText: String, val initialText: String) {
    var textState by mutableStateOf(initialText)

    fun isHint() = textState == hintText

    fun updateText(newText: String) {
        textState = newText
    }

    companion object {
        val saver: Saver<EditUserInputState, *> = listSaver(
            save = { listOf(it.hintText, it.initialText) },
            restore = {
                EditUserInputState(
                    hintText= it[0],
                    initialText = it[1]
                )
            }
        )
    }
}

/**
 * rememberSaveable to hold value across config changes.
 */
@Composable
fun rememberSaveableEditUserInputState(hintText: String, initialText: String) = rememberSaveable(saver = EditUserInputState.saver) {
    EditUserInputState(hintText, initialText)
}

@Composable
fun EditableUserInput(
    inputState: EditUserInputState,
    @DrawableRes vector: Int,
    caption: String?,
    onClick: () -> Unit
) {
    BaseUserInput(
        vectorId = vector,
        onClick = onClick,
        caption = caption
    ) {
        BasicTextField(
            cursorBrush = SolidColor(crane_purple_800),
            value = inputState.textState,
            onValueChange = { inputState.updateText(it) },
            textStyle = if (inputState.isHint())
                captionTextStyle.copy(color = crane_white)
            else
                MaterialTheme.typography.bodyLarge.copy(color = crane_white)
        )
    }
}


@Preview
@Composable
fun PreviewEditableUserInput() {
    CraneTheme {
        EditableUserInput(
            inputState = rememberSaveableEditUserInputState(hintText = "Choose a Destination", initialText = "Choose a Destination"),
            vector = R.drawable.ic_plane,
            caption = "To",
            onClick = {}
        )
    }
}