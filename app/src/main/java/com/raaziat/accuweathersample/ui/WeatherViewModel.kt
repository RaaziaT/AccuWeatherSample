package com.raaziat.accuweathersample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raaziat.accuweathersample.model.weather.DailyForecast
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class WeatherViewModel : ViewModel(){

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : WeatherRepository = WeatherRepository()


    val weatherLiveData = MutableLiveData<MutableList<DailyForecast>>()

    fun fetchMovies(){
        scope.launch {
            val popularMovies = repository.getWeather("25.14468972,67.1847767")
            weatherLiveData.postValue(popularMovies)
        }
    }


    fun cancelAllRequests() = coroutineContext.cancel()

}