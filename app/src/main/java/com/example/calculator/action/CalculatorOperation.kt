package com.example.calculator.action

sealed class CalculatorOperation (val operation:String) {
    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
    object Percent : CalculatorOperation("%")
    object Root : CalculatorOperation("√")

}