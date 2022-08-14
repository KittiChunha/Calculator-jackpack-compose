package com.example.calculator.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculator.CalculatorState
import com.example.calculator.action.CalculatorAction
import com.example.calculator.action.CalculatorOperation

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction:(CalculatorAction) -> Unit
){
    Box(modifier=modifier){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + state.operation?.operation.orEmpty()+state.number2,
                style = MaterialTheme.typography.displayLarge,
                maxLines = 3,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 25.dp),
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.onPrimary
            )

            //Button Ac,Delete,Divide
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Clear)
                }

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Delete)
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="/"
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }

            }

            /////////////////////////////////////////
            //Button %,√
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "%",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Percent))
                }

                CalculatorButton(
                    symbol = "√",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Root))
                }

            }
            /////////////////////////////////////////


            //Button 7,8,9,*
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(7))
                }

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(8))
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="9"
                ) {
                    onAction(CalculatorAction.Number(9))
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="*"
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }
            }

            //Button 4,5,6,-
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(4))
                }

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(5))
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="6"
                ) {
                    onAction(CalculatorAction.Number(6))
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="-"
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }
            }

            //Button 1,2,3,+
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(1))
                }

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(2))
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="3"
                ) {
                    onAction(CalculatorAction.Number(3))
                }

                CalculatorButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    symbol ="+"
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }
            }

            //Button 0,".",=
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .aspectRatio(2f)
                        .weight(2f)
                ) { onAction(CalculatorAction.Number(0)) }

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { onAction(CalculatorAction.Decimal) }
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                ) { onAction(CalculatorAction.Calculate) }
            }







        }
    }

}
