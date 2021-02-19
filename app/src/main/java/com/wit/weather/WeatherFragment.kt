package com.wit.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class WeatherFragment : Fragment() {

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

        val param = requireArguments()
        val Id = param.getInt("cityId")
        val Country = param.getString("Country")
        val Weather = param.getString("Weather")+ " \u2103"
        val tv_country: TextView = view.findViewById(R.id.tv_country)
        tv_country.setText(Country)
        val tv_weather_number: TextView = view.findViewById(R.id.tv_weather_number)
        tv_weather_number.setText(Weather)

    }
}