package com.example.craneapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.samples.crane.data.ExploreModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.craneapp.R
import com.example.craneapp.ui.theme.craneShape
import com.example.craneapp.ui.theme.crane_caption
import com.example.craneapp.ui.theme.crane_divider_color
import com.example.craneapp.ui.theme.crane_white
import kotlinx.coroutines.launch

@Composable
fun ExploreSection(
    headline: String,
    list: List<ExploreModel>,
    clickCallback: (ExploreModel) -> Unit
) {
    // use surface to easily pass rounded shape for corners.
    Surface(
        color = crane_white,
        shape = craneShape
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
        ) {
            Text(
                text = headline,
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(12.dp))

            Box(modifier = Modifier.fillMaxSize()) {
                val listState = rememberLazyListState()

                LazyColumn(state = listState) {
                    items(list) {
                        Column {
                            SimpleExplore(exploreModel = it, clickCallback)
                            Spacer(modifier = Modifier.height(12.dp))
                            Divider(color = crane_divider_color)
                        }
                    }
                }

                // Note:
                // state is derived from another state. calc is run everytime.
                // remember bc other recreates derived state everytime composed.
                // derived from changes. only if value != oldValue then recomp
                // Show the button if the first visible item is past
                // the first item. We use a remembered derived state to
                // minimize unnecessary recompositions
                // firstVisibleItemIndex is Int but get() is return IntState. so using this anywhere will trigger recomp whenever it changes
                // View the recomp count in Layout Inspector
                val showButton by remember {
                    derivedStateOf {
                        listState.firstVisibleItemIndex > 0
                    }
                }
                if (showButton) {
                    // show button
                    val coroutineScope = rememberCoroutineScope()
                    FloatingActionButton(
                        containerColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .navigationBarsPadding()
                            .padding(bottom = 8.dp),
                        onClick = {
                            coroutineScope.launch {
                                listState.scrollToItem(0)
                            }
                        }
                    ) {
                        Text("Up!")
                    }
                }
            }
        }
    }
}

@Composable
fun SimpleExplore(exploreModel: ExploreModel, clickCallback: (ExploreModel) -> Unit) {
    Row(
        Modifier
            .clickable { clickCallback(exploreModel) }
            .padding(top = 12.dp)
    ) {
        // allows to place a placeholder while loading with corner shape
        ImageContainer {
            Box(
                modifier = Modifier
                .fillMaxSize()
            ) {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(exploreModel.imageUrl)
                        .crossfade(true)
                        .build()
                )

                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                if (painter.state is AsyncImagePainter.State.Loading) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_crane_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(24.dp))

        Column(Modifier.weight(1f)) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = exploreModel.city.nameToDisplay,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = exploreModel.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ImageContainer(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .size(60.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        content()
    }
}