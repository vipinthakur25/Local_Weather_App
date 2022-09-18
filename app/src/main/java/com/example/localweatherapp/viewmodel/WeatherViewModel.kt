package com.example.localweatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.localweatherapp.model.WeatherDetail

class WeatherViewModel : ViewModel() {

    private val getWeatherLiveData = MutableLiveData<List<WeatherDetail>>()

    val getWeatherDetailLiveData: LiveData<List<WeatherDetail>>
        get() = getWeatherLiveData


    fun setWeatherListData() {

        val weatherList = arrayListOf<WeatherDetail>()

        weatherList.add(WeatherDetail("Indore, Madhya Pradesh", "Moon", 98.66f, 89.5f))
        weatherList.add(WeatherDetail("Mumbai, Maharashtra", "Night", 98.66f, 89.5f))
        weatherList.add(WeatherDetail("Banglore, India", "Sunny", 98.66f, 89.5f))
        weatherList.add(WeatherDetail("Chennai, India", "Cloudy", 98.66f, 89.5f))

        getWeatherLiveData.postValue(weatherList)
    }
}