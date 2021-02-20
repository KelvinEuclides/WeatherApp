package com.wit.weather

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.wit.weather.apis.Weather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.RoundingMode

class WeatherFragment : Fragment() {
    val BASE_URL = "http://api.openweathermap.org/"
    val AppId = "8668900827569559ad860f91c7a97091"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //geting atributes from other view
        val param = requireArguments()
        val country = param.getString("Country").toString()
        //view variables
        val tv_weather_number: TextView = view.findViewById(R.id.tv_weather_number)
        val tv_country: TextView = view.findViewById(R.id.tv_country)
        val tv_weather:TextView =view.findViewById(R.id.tv_weather)
        val tv_wind:TextView=view.findViewById(R.id.tv_wind)
        val tv_humidity:TextView=view.findViewById(R.id.tv_humidity)
        val tv_low:TextView=view.findViewById(R.id.tv_low)

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(ApiRequests::class.java)
        val call = service.getWeather(country,AppId)
        call.enqueue(object : Callback<Weather> {
            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (response.code() == 200) {
                    val weather = response.body()!!
                    tv_country.setText(weather.name)
                    tv_weather_number.setText(convertktoc(weather.main!!.temp).toString())
                    tv_weather.setText(weather.weather!![0].description)
                    tv_wind.setText(weather.wind!!.speed.toString()+" km/h")
                    tv_humidity.setText(weather.main!!.humidity.toString()+"&#x0025;")
                    tv_low.setText(convertktoc(weather.main!!.temp_min).toString())

                }
            }

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                Toast.makeText(activity, "Erro", Toast.LENGTH_LONG)
                Log.d("erro", t.toString())
            }

            fun convertktoc(kelvin:Double):Double{
                var celsus=kelvin-273.15
                celsus=celsus.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
                return celsus
            }

        })






    }

}
