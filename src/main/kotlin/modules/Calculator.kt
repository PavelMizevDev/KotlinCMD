package com.turashift.kotlincmd.modules

fun calc_work() {

    //Variables\Переменные
    val Num1 = readln().toDoubleOrNull()
    val Char = readln()
    val Num2 = readln().toDoubleOrNull()

    //Input validation\Проверка ввода
    if (Num1 != null && Num2 != null) {

        //Command processing\Обработка команды
        when (Char) {

            "+" -> println(Num1 + Num2)
            "-" -> println(Num1 - Num2)
            "*" -> println(Num1 * Num2)
            "/", ":" -> {

                if (Num2 != 0.0) {

                    println(Num1 / Num2)

                } else {

                    println("Input error! Division by zero: $Num1 / \'$Num2\'")

                }

            }

            else -> println("Input error! Non-existent character: $Char")

        }

    } else {

        println("Error in one of the numerical inputs: Num1: $Num1 or Num2: $Num2")

    }

}

fun calc () {

    //Variables\Переменные
    var input: String

    //Main program loop\Основной цикл
    while (true) {

        //Launch calculator\Запуск калькулятора
        calc_work()

        //Request to continue function execution\Запрос на продолжение
        print("Continue? [Y/n] ")
        input = readln()

        //Command processing\Обработка команд
        when (input) {

            "Y", "y" -> {/*The processing routine needs to be aware of this command\Нужно чтобы обработка знала об этой команде*/}
            "N", "n" -> break
            else -> {

                print("Exit cancelled due to user input error.")

            }

        }

    }

}

const val CALC_COMMAND = "calc"
