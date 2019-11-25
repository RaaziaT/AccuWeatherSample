package com.raaziat.accuweathersample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raaziat.accuweathersample.R
import com.raaziat.accuweathersample.databinding.ItemWeatherBinding
import com.raaziat.accuweathersample.model.weather.DailyForecast

class WeatherAdapter : ListAdapter<DailyForecast,WeatherAdapter.WeatherViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val itemWeatherBinding = DataBindingUtil.inflate<ItemWeatherBinding>(
            layoutInflater,
            R.layout.item_weather,
            viewGroup,
            false
        )
        return WeatherViewHolder(itemWeatherBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.itemWeatherBinding.txtViewDayTemperature.text = getItem(position).Temperature.Minimum.Value.toString()
        holder.itemWeatherBinding.txtViewNightTemperature.text = getItem(position).Temperature.Maximum.Value.toString()
        holder.itemWeatherBinding.txtViewDay.text = getItem(position).Date
    }


    class WeatherViewHolder(var itemWeatherBinding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(itemWeatherBinding.root)

    class DiffCallback : DiffUtil.ItemCallback<DailyForecast>() {
        override fun areItemsTheSame(oldItem: DailyForecast, newItem: DailyForecast): Boolean {
            return oldItem.EpochDate == newItem.EpochDate
        }

        override fun areContentsTheSame(oldItem: DailyForecast, newItem: DailyForecast): Boolean {
            return oldItem == newItem
        }
    }
}