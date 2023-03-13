package com.example.currency_app

import androidx.compose.foundation.*
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
import com.example.currency_app.constants.ExchangeScreenVariant
import com.example.currency_app.types.Currency

@Composable
fun ExchangeScreen() {

    var variantScreen by remember { mutableStateOf(ExchangeScreenVariant.EXCHANGE) }

    fun navigateToList() {
        variantScreen = ExchangeScreenVariant.EXCHANGE
    }

    fun navigateToAction() {
        variantScreen = ExchangeScreenVariant.ACTION_EXCHANGE
    }

    when (variantScreen) {
        ExchangeScreenVariant.EXCHANGE -> {
            ListCurrencySubScreen(
                navigateToAction = { navigateToAction() },
            )
        }
        ExchangeScreenVariant.ACTION_EXCHANGE -> {
            ActionExchangeSubScreen(navigateToList = { navigateToList() })
        }
    }
}

@Composable
fun ListCurrencySubScreen(navigateToAction: () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        TopBar(title = "Список валют")
        LazyColumn(modifier = Modifier.padding(bottom = 60.dp)) {
            items(Constants.CurrencyList) { currencyItem ->
                CurrencyItem(
                    currency = currencyItem,
                    navigateToAction = navigateToAction
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CurrencyItem(currency: Currency, navigateToAction: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(color = Color.White)
            .padding(vertical = 10.dp)
            .border(width = 3.dp, color = Color.Blue)
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 5.dp)
            .combinedClickable(
                onClick = { navigateToAction() },
                onLongClick = { navigateToAction() }
            )
    ) {
        Text(text = currency.shortTitle)
        if (currency.favourites) {
            IconButton(
                onClick = {},
                content = {
                    Icon(
                        painterResource(id = R.drawable.baseline_star_24_filled),
                        contentDescription = "Избранное", tint = Color.Red
                    )
                })
        } else {
            IconButton(
                onClick = {},
                content = {
                    Icon(
                        painterResource(id = R.drawable.baseline_star_border_24),
                        contentDescription = "Обычное", tint = Color.Red
                    )
                })
        }
    }
}