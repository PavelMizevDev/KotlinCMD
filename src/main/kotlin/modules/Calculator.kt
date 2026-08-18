package com.turashift.kotlincmd.modules

import calib.CaLib

//WorkingFunction
private fun calcWork() {

    println("Enter a mathematical expression for example: \"2 + 2 * 2\" or \"(10 / 2) ^ 3\".")
    print("Expression: ")

    val input = readln()

    if (input.isBlank()) {

        println("Input error: Expression cannot be empty.")
        return

    }

    //ErrorHandling
    try {

        val result = CaLib.calculate(input)
        println("Answer: $result")

    } catch (e: IllegalArgumentException) {

        println("Calculation error: ${e.message}")

    }

}

//StartFunction
fun calc() {

    //InputVariable
    var input: String

    //FunctionExitRequestCycle
    while (true) {

        calcWork()

        print("Continue? [Y/n] ")
        input = readln()

        //CommandProcessing
        when (input) {

            "Y", "y" -> {}
            "N", "n" -> break

            else -> {

                println("Exit cancelled due to user input error.")

            }

        }

    }

}

const val CALC_COMMAND = "calc"
