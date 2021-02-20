package com.wit.weather

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.wit.weather.city.CityContent

class MyCityRecyclerViewAdapter(
        private val values: List<CityContent.City>,
        private val clickListener: (idCity: Int,Country: String) -> Unit
) : RecyclerView.Adapter<MyCityRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.country.text = item.Country
        holder.itemView.setOnClickListener {
            clickListener(item.id,item.Country)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val country: TextView = view.findViewById(R.id.tv_country)
        override fun toString(): String {
            return super.toString() + "'" + country.text + "'"
        }
    }
}