package com.caren.dailyinspirationalquote.network

import com.squareup.moshi.Json

/**
 * https://premium.zenquotes.io/zenquotes-documentation/#api-response
 */
data class Quote(

    val quote: String?,

    val author: String?,

    val preformattedHTML: String?,
)