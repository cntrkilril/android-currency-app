package com.example.currency_app.types

import java.text.SimpleDateFormat
import java.util.Date

data class Exchange(
    var currencyFrom: String,
    var valueFrom: Double,
    var currencyTo: String,
    var valueTo: Double,
    var date: String = SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Date())
)
