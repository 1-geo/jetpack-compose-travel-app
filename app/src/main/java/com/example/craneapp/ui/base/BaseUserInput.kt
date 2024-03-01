package com.example.craneapp.ui.base

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.craneapp.R
import com.example.craneapp.ui.theme.CraneTheme
import com.example.craneapp.ui.theme.captionTextStyle
import com.example.craneapp.ui.theme.crane_purple_700
import com.example.craneapp.ui.theme.crane_white

@Composable
fun BaseUserInput(
    caption: String? = null,
    @DrawableRes vectorId: Int,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Surface(
        onClick = onClick,
        color = crane_purple_700
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Icon(
                painter = painterResource(id = vectorId),
                contentDescription = null,
                tint = crane_white
            )
            Spacer(modifier = Modifier.width(8.dp))
            if (caption != null) {
                Text(
                    text = caption,
                    style = captionTextStyle.copy(color = crane_white),
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                content()
            }
        }
    }
}

/**
 * Previews
 */
@Preview
@Composable
fun PreviewBaseUserInputHint() {
    CraneTheme {
        BaseUserInput(
            vectorId = R.drawable.ic_plane,
            onClick = { },
            caption = "To",
            content = {
                Text(
                    text = "Choose a Destination",
                    style = captionTextStyle.copy(color = crane_white)
                )
            }
        )
    }
}

@Preview
@Composable
fun PreviewBaseUserInputNotHint() {
    CraneTheme {
        BaseUserInput(
            vectorId = R.drawable.ic_hotel,
            onClick = { },
            caption = "From",
            content = {
                Text(
                    text = "Seoul, South Korea",
                    style = MaterialTheme.typography.bodyLarge.copy(color = crane_white)
                )
            }
        )
    }
}

@Preview
@Composable
fun PreviewBaseUserInputNoCaption() {
    CraneTheme {
        BaseUserInput(
            vectorId = R.drawable.ic_hotel,
            onClick = { },
            content = {
                Text(
                    text = "1 Adult, Economy",
                    style = MaterialTheme.typography.bodyLarge.copy(color = crane_white)
                )
            }
        )
    }
}
