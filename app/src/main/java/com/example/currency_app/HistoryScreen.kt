package com.example.currency_app


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.currency_app.components.TopBar
import com.example.currency_app.constants.Constants
import com.example.currency_app.constants.HistoryScreenVariant
import com.example.currency_app.types.Exchange

@Composable
fun HistoryScreen() {
    var variantScreen by remember { mutableStateOf(HistoryScreenVariant.HISTORY) }

    fun navigateToList() {
        variantScreen = HistoryScreenVariant.HISTORY
    }

    fun navigateToFilter() {
        variantScreen = HistoryScreenVariant.FILTER
    }

    when (variantScreen) {
        HistoryScreenVariant.HISTORY -> {
            ListHistorySubScreen(
                navigateToFilter = { navigateToFilter() },
            )
        }
        HistoryScreenVariant.FILTER -> {
            FilterHistorySubScreen(navigateToList = { navigateToList() })
        }
    }
}

@Composable
fun ListHistorySubScreen(navigateToFilter: () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        TopBar(
            title = "История обменов",
            icon = R.drawable.baseline_filter_alt_24,
            actionOnIcon = navigateToFilter
        )

        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            items(Constants.ExchangeList) { exchangeItem ->
                CurrencyItem(exchange = exchangeItem)
            }
        }
    }
}

@Composable
fun CurrencyItem(exchange: Exchange) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Color.White)
            .padding(vertical = 10.dp)
            .border(width = 3.dp, color = Color.Blue)
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 5.dp)
    ) {
        Row() {
            Text(text = exchange.valueFrom.toString(), Modifier.padding(end = 5.dp))
            Text(text = exchange.currencyFrom)
        }
        IconButton(onClick = {},
            content = {
                Icon(
                    painterResource(id = R.drawable.baseline_arrow_forward_24),
                    contentDescription = "", tint = Color.Blue
                )
            })
        Row() {
            Text(text = exchange.valueTo.toString(), Modifier.padding(end = 5.dp))
            Text(text = exchange.currencyTo)
        }
        Text(text = exchange.date)
    }
}