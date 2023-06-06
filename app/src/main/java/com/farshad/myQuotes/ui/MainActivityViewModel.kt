package com.farshad.myQuotes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farshad.myQuotes.data.model.domain.DomainQuote
import com.farshad.myQuotes.data.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val quoteRepository: QuoteRepository
): ViewModel() {

    private val _appState= MutableStateFlow(AppState.initial())
    val appState= _appState.asStateFlow()


    fun getQuotOfToday()= viewModelScope.launch {
        val response= quoteRepository.getQuotOfToday()
        _appState.update {currentState ->
            return@update currentState.copy(
                quoteOfToday = response
            )
        }
    }



     fun onNavigationClick(page: AppState.Page){
        _appState.update {currentState ->
            return@update currentState.copy(
                navigation = AppState.Navigation(
                    items = currentState.navigation.items,
                    selectedItem = page
                )
            )
        }
    }


    fun onFavoriteClick(quote: DomainQuote){
        _appState.update { currentState->
            return@update currentState.copy(
                quoteOfToday = quote.copy(isFavorite = !quote.isFavorite)
            )
        }
    }











}