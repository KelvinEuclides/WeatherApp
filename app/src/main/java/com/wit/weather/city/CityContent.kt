package com.wit.weather.city

import java.util.ArrayList
import java.util.HashMap


object CityContent {


    val ITEMS: MutableList<City> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, City> = HashMap()

    var Cities = arrayOf("Lisboa","Madrid","Paris","Berlim","Copenhaga","Roma","Londres","Dublin","Praga","Viena")
    init {

        for ((index,i) in Cities.withIndex()) {
            addItem(createCity(index,i))
        }
    }

    private fun addItem(item: City) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id.toString(), item)
    }

    private fun createCity(id: Int,city: String): City {
        return City(id,city, 32, "teste")
    }

    data class City(val id:Int, val Country: String, val Weather: Int, val Description:String) {
        override fun toString(): String = Country
    }
}