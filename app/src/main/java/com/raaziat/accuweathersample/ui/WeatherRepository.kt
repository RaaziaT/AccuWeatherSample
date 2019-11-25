package com.raaziat.accuweathersample.ui

import com.raaziat.accuweathersample.model.weather.DailyForecast
import com.raaziat.accuweathersample.network.ApiFactory
import com.raaziat.accuweathersample.network.BaseRepository

class WeatherRepository() : BaseRepository(){

    val api = ApiFactory.networkInterfaces

    suspend fun getWeather(q:String) :MutableList<DailyForecast>?{

        //safeApiCall is defined in BaseRepository.kt (https://gist.github.com/navi25/67176730f5595b3f1fb5095062a92f15)
        val locationResponse = safeApiCall(
            call = {api.getLocation(q).await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        val locationKey = locationResponse?.Key;

        val weatherResponse = safeApiCall(
            call = {api.getWeather(locationKey!!.toInt()).await()},
            errorMessage = "Error Fetching Popular Movies"
        )

        return weatherResponse?.DailyForecasts?.toMutableList();
    }
}