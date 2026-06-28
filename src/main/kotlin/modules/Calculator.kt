package com.turashift.kotlincmd.modules

private fun calc_work() {

    //Variables\Переменные
    val input = readln()
    val Num1: Any?
    val Char: Any?
    val Num2: Any?

    println("Enter with spaces, for example: \"723 + 127\" or \"72 / 8\".")

    //Fragmentation\Раздробление
    var list = input.split(" ")

    //Array processing\Обработка массива
    if (list.size == 3) {

        Num1 = list[0].toDoubleOrNull()
        Char = list[1]
        Num2 = list[2].toDoubleOrNull()

    } else {

        println("Input error: $list")
        return

    }

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

        println("Error in one of the numerical inputs: $list")

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
