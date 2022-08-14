package com.example.calculator

import com.example.calculator.action.CalculatorOperation

data class CalculatorState(
  val number1:String="",
  val number2:String ="",
  val operation: CalculatorOperation? = null,
)