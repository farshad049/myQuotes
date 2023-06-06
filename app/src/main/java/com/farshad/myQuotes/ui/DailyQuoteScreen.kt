package com.farshad.myQuotes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farshad.myQuotes.data.model.domain.DomainQuote


@Composable
fun DailyQuoteScreen(
    quote: DomainQuote,
    onClick: (DomainQuote) -> Unit
){

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(all = 32.dp)
                .background(
                    color = MaterialTheme.colors.primary,
                    shape = MaterialTheme.shapes.large,
                )
                .clip(shape = MaterialTheme.shapes.large)
        ){
            Text(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(vertical = 12.dp, horizontal = 12.dp),
                text = quote.quote,
                fontSize = 24.sp,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                    .background(color = Color.Black)
                    .padding(vertical = 8.dp, horizontal = 12.dp),
                text = quote.author,
                fontSize = 12.sp,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.End,
                overflow = TextOverflow.Ellipsis
            )

            Box(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 12.dp)
                    .align(Alignment.BottomStart)
                    .background(color = MaterialTheme.colors.primaryVariant, shape = RoundedCornerShape(50.dp))
                    .size(60.dp)
                    .border(width = 1.dp, color = MaterialTheme.colors.onSurface, shape = RoundedCornerShape(50.dp))
                    .clip(shape = RoundedCornerShape(50.dp))
                    .clickable {onClick(quote)},
            )
            {
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center),
                    imageVector = if (quote.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite Icon",
                    tint = MaterialTheme.colors.onSurface
                )
            }







        }

    }

}





