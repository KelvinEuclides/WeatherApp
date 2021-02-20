package com.wit.weather

import retrofit2.Call
import retrofit2.http.GET
import com.wit.weather.apis.Weather
import retrofit2.http.Query

interface ApiRequests {
    @GET("data/2.5/weather?")
    fun getWeather(@Query("q") q:String,@Query("appid") appid:String): Call<Weather>
}