package com.caren.dailyinspirationalquote.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = ""

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * https://zenquotes.io/#docs
 */
interface ZenQuotesApiService {

    // https://zenquotes.io/api/random
    @GET("random")
    suspend fun getRandomQuote(): List<Quote>

}

object ZenQuotesApi {
    val retrofitService: ZenQuotesApiService by lazy { retrofit.create(ZenQuotesApiService::class.java) }
}