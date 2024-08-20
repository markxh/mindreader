package com.markxh.mindreader.ui.guesstile.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun GuessTIleScreen() {
    var selectedTile by remember { mutableIntStateOf(-1) }
    val correctTile = remember { Random.nextInt(9) }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed((0 until 9).chunked(3)) { rowIndex, rowItems ->
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                rowItems.forEach { index ->
                    val color = when {
                        selectedTile == -1 -> Color.Gray
                        index == correctTile -> Color.Green
                        else -> Color.Red
                    }

                    Surface(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                selectedTile = index
                            },
                        color = color
                    ) {}
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewGuessTileScreen() {
    GuessTIleScreen()
}