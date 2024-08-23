package com.markxh.mindreader.ui.guesstile.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun GuessTileScreen() {
    var selectedTile by remember { mutableStateOf(-1) }
    var correctTile by remember { mutableStateOf(Random.nextInt(9)) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Grid of tiles
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            itemsIndexed((0 until 9).chunked(3)) { rowIndex, rowItems ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
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

        // Reset Button
        Button(
            onClick = {
                selectedTile = -1
                correctTile = Random.nextInt(9)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            androidx.compose.material3.Text(text = "Reset")
        }
    }
}

@Preview
@Composable
fun PreviewGuessTileScreen() {
    GuessTileScreen()
}