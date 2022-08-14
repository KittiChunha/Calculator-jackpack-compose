package com.example.calculator.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback

@Composable
fun CalculatorButton(
    modifier: Modifier,
    symbol:String,
    onClick:() -> Unit
){
    //Android haptics
    val haptics = LocalHapticFeedback.current
    ElevatedButton(
        modifier = modifier,
        onClick = {
            haptics.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        },
        shape = CircleShape
    ) {
        Text(
            text = symbol,
            style = MaterialTheme.typography.displaySmall
        )

    }


}