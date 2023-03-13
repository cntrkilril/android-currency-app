package com.example.currency_app.constants

import com.example.currency_app.types.BottomNavItem
import com.example.currency_app.R
import com.example.currency_app.types.Currency
import com.example.currency_app.types.Exchange


object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            title = "Обмен",
            icon = R.drawable.baseline_currency_exchange_24,
            route = "exchange"
        ),
        BottomNavItem(
            title = "Аналитика",
            icon = R.drawable.baseline_analytics_24,
            route = "analytic"
        ),
        BottomNavItem(
            title = "История",
            icon = R.drawable.baseline_history_24,
            route = "history"
        )
    )
    val CurrencyList = listOf(
        Currency(shortTitle = "RUB", favourites = true),
        Currency(shortTitle = "EUR"),
        Currency(shortTitle = "AUD"),
        Currency(shortTitle = "IQD"),
        Currency(shortTitle = "JPY"),
        Currency(shortTitle = "KZT"),
        Currency(shortTitle = "KRW"),
        Currency(shortTitle = "KWD"),
        Currency(shortTitle = "LAK"),
        Currency(shortTitle = "MVR"),
    )
    val ExchangeList = listOf(
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
        Exchange(valueFrom = 500.0, currencyFrom = "RUB", currencyTo = "USD", valueTo = 7.2),
    )
}