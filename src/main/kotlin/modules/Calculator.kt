package com.turashift.kotlincmd.modules

import calib.CaLib

private fun calcWork() {

    println("Enter a mathematical expression for example: \"2 + 2 * 2\" or \"(10 / 2) ^ 3\".")
    print("Expression: ")

    //User input prompt\Запрос ввода пользователя
    val input = readln()

    if (input.isBlank()) {

        println("Input error: Expression cannot be empty.")
        return

    }

    //Error handling\Обработка ошибок
    try {

        val result = CaLib.calculate(input)
        println("Answer: $result")

    } catch (e: IllegalArgumentException) {

        println("Calculation error: ${e.message}")

    }

}

//Function launch\Запуск функция
fun calc() {

    var input: String

    //Exit request cycle\Цикл запроса выхода
    while (true) {

        calcWork() //Launching the process function\Запуск процесс-функции

        print("Continue? [Y/n] ")
        input = readln() //User input prompt\Запрос ввода пользователя

        //Command processing\Обработка команды
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
