package com.caren.dailyinspirationalquote.network

import com.squareup.moshi.Json

/**
 * https://premium.zenquotes.io/zenquotes-documentation/#api-response
 */
data class Quote(

    @Json(name="q") val quote: String?,

    @Json(name="a") val author: String?,

    @Json(name="h") val preformattedHTML: String?,
)