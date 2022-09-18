package com.example.localweatherapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.localweatherapp.R
import com.example.localweatherapp.databinding.FragmentWeatherDetailBinding
import com.example.localweatherapp.viewmodel.WeatherViewModel


class WeatherDetailFragment : Fragment() {
    private lateinit var viewModel: WeatherViewModel
    private lateinit var binding: FragmentWeatherDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_weather_detail, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        viewModel = ViewModelProvider(requireActivity()).get(WeatherViewModel::class.java)
        val rndPosition = (0..3).shuffled().last()
        var kelvin = 273.15
        Toast.makeText(requireContext(), "$rndPosition", Toast.LENGTH_SHORT).show()
        viewModel.getWeatherDetailLiveData.observe(viewLifecycleOwner) {

            binding.tvDayType.text = it[rndPosition].dayType
            binding.tvAddress.text = it[rndPosition].cityName
            binding.tvCity.text = it[rndPosition].cityName
            binding.tvTemperature.text = it[rndPosition].temperature.toString() + "\u2103"
            binding.tvTemp.text = it[rndPosition].temperature.toString() + "\u2103"
            kelvin += it[rndPosition].temperature
            binding.tvWindSpeed.text = it[rndPosition].windSpeed.toString()
            binding.tvWind.text = it[rndPosition].windSpeed.toString()
            binding.tvTemp.setOnClickListener { binding.tvTemp.text = "$kelvin K" }

        }


        viewModel.setWeatherListData()
    }


}