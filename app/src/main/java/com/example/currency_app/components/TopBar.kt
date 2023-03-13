package com.example.currency_app.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(title: String, icon: Int? = null, actionOnIcon: () -> Unit = {}) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = title,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
        )
        if (icon != null) {
            IconButton(onClick = { actionOnIcon() },
                content = {
                    Icon(
                        painterResource(id = icon),
                        contentDescription = "", tint = Color.Blue
                    )
                })
        }
    }
}