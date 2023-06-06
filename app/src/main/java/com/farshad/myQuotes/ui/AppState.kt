package com.farshad.myQuotes.ui

import androidx.compose.ui.graphics.Color
import com.farshad.myQuotes.data.model.domain.DomainQuote


data class AppState(
    val navigation: Navigation,
    val quoteOfToday: DomainQuote?
)
{
    data class Navigation(
        val items: List<Page>,
        val selectedItem: Page
    )

    data class Page(
        val title: String,
        val color: Color
    )

    

    companion object{
        fun initial(): AppState {
            val pages= buildList{
                add(Page("All quotes", Color.Red))
                add(Page("Daily quote", Color.Blue))
                add(Page("Favorites", Color.Green))
            }
            return AppState(
                navigation = Navigation(
                    items = pages,
                    selectedItem = pages[1]
                ),
                quoteOfToday = DomainQuote(
                    quote = "Nothing good ever comes of violence.",
                    author = "Martin Luther",
                    isFavorite = true
                )
            )
        }
    }


}