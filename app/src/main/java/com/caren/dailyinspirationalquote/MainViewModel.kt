package com.caren.dailyinspirationalquote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caren.dailyinspirationalquote.network.Quote
import com.caren.dailyinspirationalquote.network.ZenQuotesApi
import com.caren.dailyinspirationalquote.network.ZenQuotesApiService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _currentlyDisplayedQuote = MutableLiveData<Quote>()
    val currentlyDisplayedQuote: LiveData<Quote> = _currentlyDisplayedQuote


    init {
        getNewQuote()
    }

    fun getNewQuote() {
        viewModelScope.launch {
            // The response from https://zenquotes.io/api/random is a list of 1 quote, so we
            // are getting the first item in the list from the response.

            _currentlyDisplayedQuote.value = ZenQuotesApi.retrofitService.getRandomQuote()[0]
        }
    }
}