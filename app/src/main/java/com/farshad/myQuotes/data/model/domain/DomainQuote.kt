package com.farshad.myQuotes.data.model.domain

data class DomainQuote(
    val quote: String,
    val author: String,
    val isFavorite: Boolean= false
)

