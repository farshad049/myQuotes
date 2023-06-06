package com.farshad.myQuotes.data.model.mapper

import com.farshad.myQuotes.data.model.domain.DomainQuote
import com.farshad.myQuotes.data.model.network.NetworkQuote
import javax.inject.Inject

class QuoteMapper @Inject constructor() {

    fun buildFromNetworkQuote(networkQuote: NetworkQuote): DomainQuote{

        return DomainQuote(
            quote = networkQuote.q,
            author = networkQuote.a,
        )

    }

}