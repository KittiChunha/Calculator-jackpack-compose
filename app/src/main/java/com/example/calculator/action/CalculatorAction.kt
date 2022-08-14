package com.example.calculator.action

sealed class CalculatorAction {
    //All Delete
    object Clear:CalculatorAction()
    //Delete
    object Delete : CalculatorAction()
    // decimal(".")
    object Decimal : CalculatorAction()
    // Process
    object Calculate : CalculatorAction()
    // Number (1,2,3,...)
    data class Number(val number:Int):CalculatorAction()
    // Operation (+,-,*,/)
    data class Operation(val operation:CalculatorOperation):CalculatorAction()
}