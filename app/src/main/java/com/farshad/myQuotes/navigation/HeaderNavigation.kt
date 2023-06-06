package com.farshad.myQuotes.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farshad.myQuotes.ui.AppState
import com.farshad.myQuotes.thenIf


@Composable
fun NavigationHeader(
    navigation: AppState.Navigation,
    onClick: (AppState.Page)-> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.large.copy(
                    topStart = CornerSize(0),
                    topEnd = CornerSize(0)
                )
            )
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        navigation.items.forEach { page ->
            val isSelected= page.title == navigation.selectedItem.title
            val fontWeight= if (isSelected) FontWeight.Normal else FontWeight.Light


            Text(
                text = page.title,
                fontWeight = fontWeight,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable { onClick(page) }
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = MaterialTheme.shapes.medium
                    )
                    .thenIf(isSelected) {
                        Modifier.border(
                            width = 1.dp,
                            color = MaterialTheme.colors.onSurface,
                            shape = MaterialTheme.shapes.medium
                        )
                    }
                    .padding(
                        horizontal = 24.dp,
                        vertical = 8.dp
                    )
            )

        }

    }

}


