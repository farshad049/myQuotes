package com.farshad.myQuotes.data.network


import com.farshad.myQuotes.data.model.network.NetworkQuote
import retrofit2.Response
import retrofit2.http.GET


interface QuoteService {

    @GET("today")
    suspend fun getQuoteOfToday(): Response<List<NetworkQuote>>

}