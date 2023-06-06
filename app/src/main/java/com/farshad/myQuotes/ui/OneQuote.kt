package com.farshad.myQuotes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.farshad.myQuotes.navigation.NavigationHeader
import com.farshad.myQuotes.ui.theme.ZenQuotesTheme





@Composable
fun OneQuoteApp(
    viewModel: MainActivityViewModel= viewModel()
){
    val appState by viewModel.appState.collectAsStateWithLifecycle()

    viewModel.getQuotOfToday()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        NavigationHeader(
            navigation = appState.navigation,
            onClick = { viewModel.onNavigationClick(it)}
        )


        val selectedPage= appState.navigation.selectedItem

        when(selectedPage.title){
            "All quotes" ->{
                TempContent(itemColor = selectedPage.color)
            }
            "Daily quote" ->{
                appState.quoteOfToday?.let { DailyQuoteScreen(quote = it, onClick = { favoriteItem-> viewModel.onFavoriteClick(favoriteItem)}) }

            }
            "Favorites" ->{
                TempContent(itemColor = selectedPage.color )
                TempContent(itemColor = selectedPage.color )
                TempContent(itemColor = selectedPage.color )

            }
        }



    }



}



@Composable
 fun TempContent(itemColor: Color){
    Box(
        modifier = Modifier
            .padding(all = 32.dp)
            .height(16.dp)
            .fillMaxWidth()
            .background(
                color = itemColor,
                shape = MaterialTheme.shapes.medium
            )
    )
}





@Preview
@Composable
fun Fss(){
    ZenQuotesTheme {
        OneQuoteApp()
    }

}