package com.example.currency_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.example.currency_app.components.TopBar
import com.example.currency_app.constants.Constants
import com.example.currency_app.constants.PeriodFilterAnalytic
import com.example.currency_app.constants.PeriodFilterHistory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalyticScreen() {
    var expanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember { mutableStateOf("RUB") }
    val selectedPeriod = remember { mutableStateOf(PeriodFilterAnalytic.WEEK) }

    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        TopBar(title = "Тенденция роста")
        Box(modifier = Modifier.padding(vertical = 5.dp)) {
            ExposedDropdownMenuBox(
                expanded = true,
                onExpandedChange = { expanded = !expanded },
            ) {
                TextField(
                    value = selectedCurrency,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor()
                        .focusRequester(focusRequester)
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    Modifier.fillMaxWidth()
                ) {
                    Constants.CurrencyList.forEach { currency ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = currency.shortTitle,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            },
                            onClick = {
                                selectedCurrency = currency.shortTitle
                                expanded = false
                            })
                    }
                }
            }
        }

        Text(text = "Здесь будет график")

        Row(Modifier.selectableGroup()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedPeriod.value == PeriodFilterAnalytic.WEEK,
                    onClick = { selectedPeriod.value = PeriodFilterAnalytic.WEEK })
                Text(text = "Неделя")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedPeriod.value == PeriodFilterAnalytic.TWO_WEEK,
                    onClick = { selectedPeriod.value = PeriodFilterAnalytic.TWO_WEEK })
                Text(text = "Две недели")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedPeriod.value == PeriodFilterAnalytic.MONTH,
                    onClick = { selectedPeriod.value = PeriodFilterAnalytic.MONTH })
                Text(text = "Месяц")
            }
        }
    }


}