package com.raaziat.accuweathersample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raaziat.accuweathersample.R
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {

    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var weatherAdapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        weatherViewModel.fetchMovies()

        weatherAdapter = WeatherAdapter()
        initializeRecyclerView()



        weatherViewModel.weatherLiveData.observe(this, Observer {
            weatherAdapter.submitList(it)
        })
    }

    private fun initializeRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView_weather.layoutManager = linearLayoutManager
        recyclerView_weather.adapter = weatherAdapter
    }
}
