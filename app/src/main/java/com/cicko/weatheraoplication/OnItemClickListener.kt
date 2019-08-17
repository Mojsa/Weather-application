package com.cicko.weatheraoplication

import com.cicko.weatheraoplication.domain.Forecast

interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}