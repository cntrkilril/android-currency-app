package com.example.currency_app


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.currency_app.components.TopBar
import com.example.currency_app.constants.Constants
import com.example.currency_app.constants.PeriodFilterHistory
import com.example.currency_app.types.Currency

@Composable
fun FilterHistorySubScreen(navigateToList: () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        TopBar(title = "Фильтр")
        FilterBlock(navigateToList = { navigateToList() })
    }
}

@Composable
fun FilterBlock(navigateToList: () -> Unit) {
    val period = remember { mutableStateOf(PeriodFilterHistory.ALL_TIME) }
    Column() {
        Row() {
            Text(text = "Период")
            Column(Modifier.selectableGroup()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = period.value == PeriodFilterHistory.ALL_TIME,
                        onClick = { period.value = PeriodFilterHistory.ALL_TIME })
                    Text(text = "Все время")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = period.value == PeriodFilterHistory.WEEK,
                        onClick = { period.value = PeriodFilterHistory.WEEK })
                    Text(text = "Неделя")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = period.value == PeriodFilterHistory.MONTH,
                        onClick = { period.value = PeriodFilterHistory.MONTH })
                    Text(text = "Месяц")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = period.value == PeriodFilterHistory.CHOICE,
                        onClick = { period.value = PeriodFilterHistory.CHOICE })
                    Text(text = "Выбор периода")
                }
            }
        }
        if (period.value == PeriodFilterHistory.CHOICE) {
            Row {
                Column() {
                    Text(text = "Начало")
                    DateTextField()
                }
                Column() {
                    Text(text = "Конец")
                    DateTextField()
                }
            }
        }
        Row() {
            Text(text = "Валюты")
            LazyColumnCurrencyCheckbox(currencyList = Constants.CurrencyList)
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { navigateToList() }) {
                Text(text = "Применить")
            }
        }
    }
}

@Composable
fun LazyColumnCurrencyCheckbox(currencyList: List<Currency>) {
    val checkedState = remember { mutableStateOf("RUB") }
    LazyColumn(modifier = Modifier.height(300.dp)) {
        items(currencyList) { currencyItem ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = currencyItem.shortTitle === checkedState.value,
                    onCheckedChange = { checkedState.value = currencyItem.shortTitle }
                )
                Text(text = currencyItem.shortTitle)
            }
        }
    }
}

@Composable
fun DateTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        modifier = Modifier.width(200.dp),
        onValueChange = { newText -> text = newText })
}