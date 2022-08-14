package com.example.calculator.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.CalculatorState
import com.example.calculator.action.CalculatorAction
import com.example.calculator.action.CalculatorOperation
import kotlin.math.sqrt

class CalculatorViewModel : ViewModel() {

    //เขียนและ อ่านค่า
   var state by mutableStateOf(CalculatorState())
    private set

    fun onAction(action:CalculatorAction){
        when (action){
            CalculatorAction.Calculate -> performCalculation()
            CalculatorAction.Clear -> performClear()
            CalculatorAction.Decimal -> onDecimal()
            CalculatorAction.Delete -> performDelete()
            is CalculatorAction.Number -> onNumber(action.number)
            is CalculatorAction.Operation -> onOperation(action.operation)
        }

    }

    private fun onOperation(operation: CalculatorOperation) {
        if(state.operation == null&& state.number1.isNotBlank()){
            state = state.copy(
                operation = operation
            )
        }else if(state.operation != null){
            state =state.copy(
                operation =operation
            )
        }

    }

    private fun onNumber(number: Int) {
        state = if (state.operation == null){
            state.copy(
                number1 = state.number1.plus(number)
            )
        }else {
            state.copy(
                number2 = state.number2.plus(number)
            )
        }

    }

    private fun performDelete() {
        if(state.operation==null && state.number1.isNotBlank()){
            state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }else if(state.number2.isNotBlank()){
            state = state.copy(number2 = state.number2.dropLast(1))
            return
        }else{
            state = state.copy(operation = null)
        }
    }

    private fun onDecimal() {
        if(state.operation==null && state.number1.isNotBlank()&& !state.number1.contains(".")){
            state = state.copy(number1 = state.number1.plus("."))
            return
        }

        if(state.number2.isNotBlank() && !state.number2.contains(".")){
            state=state.copy(number2 = state.number2.plus("."))
            return
        }
    }

    private fun performClear() {
        state = CalculatorState()
    }

    private fun performCalculation() {
        var number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if(number1 != null && number2 != null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Percent -> (number2/100)*number1
                null -> return
                is CalculatorOperation.Root -> return
            }
            state = state.copy(
                number1 = result.toString().take(5),
                number2 = "",
                operation = null,
            )
        }
        if(number1 != null && number2 == null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> return
                is CalculatorOperation.Divide -> return
                is CalculatorOperation.Multiply -> return
                is CalculatorOperation.Subtract -> return
                is CalculatorOperation.Percent -> return
                null -> return
                is CalculatorOperation.Root -> sqrt(number1)
            }
            state = state.copy(
                number1 = result.toString().take(5),
                number2 = "",
                operation = null,
            )
        }

        }

    }
