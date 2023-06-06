package com.farshad.myQuotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import com.farshad.myQuotes.ui.OneQuoteApp
import com.farshad.myQuotes.ui.theme.ZenQuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZenQuotesTheme {
                OneQuoteApp()
            }
        }
    }
}


inline fun Modifier.thenIf(isSelected: Boolean, modify: ()-> Modifier): Modifier {
    return this.then(if (isSelected) modify() else Modifier)
}

