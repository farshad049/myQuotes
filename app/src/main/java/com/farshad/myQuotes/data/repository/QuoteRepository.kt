package com.farshad.myQuotes.data.repository

import com.farshad.myQuotes.data.model.domain.DomainQuote
import com.farshad.myQuotes.data.model.mapper.QuoteMapper
import com.farshad.myQuotes.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val quoteService: QuoteService,
    private val quoteMapper: QuoteMapper
) {

    suspend fun getQuotOfToday(): DomainQuote?{
        val response= quoteService.getQuoteOfToday().body()?.firstOrNull()
        return response?.let { quoteMapper.buildFromNetworkQuote(it) }
    }
}