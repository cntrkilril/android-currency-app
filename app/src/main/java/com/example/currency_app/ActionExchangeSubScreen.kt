package com.example.currency_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.currency_app.components.TopBar

@Composable
fun ActionExchangeSubScreen(navigateToList: () -> Unit) {

    val rate by remember { mutableStateOf("2.0") }
    var valueFromCurrency by remember { mutableStateOf("1.0") }
    var valueToCurrency by remember { mutableStateOf((valueFromCurrency.toDouble() * rate.toDouble()).toString()) }

    val pattern = "\\d?(.\\d+)?".toRegex()

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        TopBar(title = "Обмен")
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "RUB")
                TextField(
                    value = valueFromCurrency,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(pattern)) {
                            if (it.isEmpty()) {
                                valueFromCurrency = "0"
                                valueToCurrency = "0"
                            } else {
                                valueFromCurrency = it
                                valueToCurrency =
                                    (valueFromCurrency.toDouble() * rate.toDouble()).toString()
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "USD")
                TextField(
                    value = valueToCurrency,
                    onValueChange = {
                        if (it.isEmpty() || it.matches(pattern)) {
                            if (it.isEmpty()) {
                                valueFromCurrency = "0"
                                valueToCurrency = "0"
                            } else {
                                valueToCurrency = it
                                valueFromCurrency =
                                    (valueToCurrency.toDouble() / rate.toDouble()).toString()
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { navigateToList() }) {
                    Text(text = "Применить")
                }
            }
        }
    }
}