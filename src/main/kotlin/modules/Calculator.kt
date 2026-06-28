package com.turashift.kotlincmd.modules

import com.calib.CaLib

private fun calc_work() {
    println("Enter a mathematical expression for example: \"2 + 2 * 2\" or \"(10 / 2) ^ 3\".")
    print("Expression: ")
    val input = readln()

    if (input.isBlank()) {
        println("Input error: Expression cannot be empty.")
        return
    }

    try {
        val result = CaLib.calculate(input)
        println("Answer: $result")
    } catch (e: IllegalArgumentException) {
        println("Calculation error: ${e.message}")
    }
}

fun calc() {
    var input: String

    while (true) {
        calc_work()
        print("Continue? [Y/n] ")
        input = readln()

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
