package com.example.basiccalculator

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccalculator.ui.theme.BasicCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCalculatorTheme {
                calculatorApp()
            }
        }
    }
}

@Composable
fun calculatorApp (modifier: Modifier = Modifier)
{
    var value1 by remember {
        mutableStateOf(0)
    }
    var value2 by remember {
        mutableStateOf(0)
    }
    var result by remember {
        mutableStateOf(0)
    }
    var stage by remember {
        mutableStateOf(1)
        //stage 1, inputting value1
        //stage 2, inputting value2
        //stage 3, displaying result
    }
    var display by remember {
        mutableStateOf("")
    }
    var operation by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    )
    {
        Text(text = display, modifier = Modifier.fillMaxWidth().wrapContentWidth(), fontSize = 20.sp)//change this when button
        Spacer(modifier = Modifier.height(65.dp))
        Row(//buttons
            modifier = Modifier.fillMaxWidth().wrapContentWidth()
        )
        {
            Column(//this is for number buttons
                modifier = Modifier.fillMaxHeight().wrapContentHeight()
            )
            {
                Row(// 1 - 3

                )
                {
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 1)
                            display += "1"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 1)
                            display += "1"
                        }

                    })
                    {
                        Text(text = "1")
                    }
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 2)
                            display += "2"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 2)
                            display += "2"
                        }

                    })
                    {
                        Text(text = "2")
                    }
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 3)
                            display += "3"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 3)
                            display += "3"
                        }

                    })
                    {
                        Text(text = "3")
                    }
                }
                Row(// 4 - 6

                )
                {
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 4)
                            display += "4"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 4)
                            display += "4"
                        }

                    })
                    {
                        Text(text = "4")
                    }
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 5)
                            display += "5"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 5)
                            display += "5"
                        }

                    })
                    {
                        Text(text = "5")
                    }
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 6)
                            display += "6"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 6)
                            display += "6"
                        }

                    })
                    {
                        Text(text = "6")
                    }
                }
                Row(// 7 - 9

                )
                {
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 7)
                            display += "7"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 7)
                            display += "7"
                        }

                    })
                    {
                        Text(text = "7")
                    }
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 8)
                            display += "8"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 8)
                            display += "8"
                        }

                    })
                    {
                        Text(text = "8")
                    }
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 9)
                            display += "9"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 9)
                            display += "9"
                        }

                    })
                    {
                        Text(text = "9")
                    }
                }
                Row()
                {
                    Spacer(modifier = Modifier.width(65.dp))
                    Button(onClick = {
                        if (stage == 1)
                        {
                            addDigit(value1, 0)
                            display += "0"
                        }
                        else if (stage == 2)
                        {
                            addDigit(value2, 0)
                            display += "0"
                        }

                    }
                    )
                    {
                        Text(text = "0")
                    }
                }
            }
            Column(//this is for operation buttons
                modifier = Modifier.fillMaxHeight().wrapContentHeight()
            )
            {
                Button(onClick = {
                    if (stage == 1 && operation.equals(""))
                    {
                        operation = "+"
                        stage++
                        display += " + "
                    }
                    //no else, only works on stage 1
                })
                {
                    Text(text = "+")
                }
                Button(onClick = {
                    if (stage == 1 && operation.equals(""))
                    {
                        operation = "-"
                        stage++
                        display += " - "
                    }
                })
                {
                    Text(text = "-")
                }
                Button(onClick = {
                    if (stage == 2)
                    {
                        result = calculateResult(value1, value2, operation)
                        display = ""
                        display += result
                        stage++
                    }
                })
                {
                    Text(text = "=")
                }
                Button(onClick = {
                    display = ""
                    value1 = 0
                    value2 = 0
                    result = 0
                    operation = ""
                    stage = 1
                })
                {
                    Text(text = "clr")
                }
            }
        }
    }
}

fun addDigit (number : Int, digit : Int): Int
{
    return (number * 10) + digit
}

fun calculateResult (num1: Int, num2: Int, operator: String) : Int
{
    var result = 0
    if (operator.equals("+"))
    {
        result = num1 + num2
    }
    else if (operator.equals("-"))
    {
        result = num1 - num2
    }
    return result
}

@Preview
@Composable
fun calculatorAppPreview()
{
    calculatorApp()
}