package com.plcoding.cryptocurrencyappyt.presentation.coin_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Tag (
    tag: String
){
    Box(modifier = Modifier
        .border(
            width = 0.dp,
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(150.dp)
        )
        .padding(10.dp)
    ){
        Text(
            text = tag,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2
        )
    }
}