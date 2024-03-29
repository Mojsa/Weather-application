package com.cicko.weatheraoplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cicko.weatheraoplication.domain.Forecast
import com.cicko.weatheraoplication.domain.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class ForecastListAdapter (private val weekForecast: ForecastList, private val itemClick: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit): RecyclerView.ViewHolder(view)  {
        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
             with(forecast) {
                 Picasso.with(itemView.context).load(iconUrl).into(iconView)
                 dateView.text = date
                 descriptionView.text = description
                 maxTemperatureView.text = "$high"
                 minTemperatureView.text = "$low"
                 itemView.setOnClickListener { itemClick(this) }
                 }
             }
    }
}