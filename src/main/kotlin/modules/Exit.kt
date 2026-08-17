package com.turashift.kotlincmd.modules

fun exit(): Boolean {

    //Exit val\Переменная выхода
    var output: Boolean

    //Confirmation request\Запрос подтверждения
    print("Confirm exit? [Y/n] ")

    //User confirmation\Ввод подтверждения
    val confirm = readln()

    //Command processing\Обработка команды
    when (confirm) {

        "Y", "y" -> {

            output = false

        }
        "N", "n" -> {

            print("Exit cancelled!")
            output = true

        }
        else -> {

            print("Exit cancelled due to user input error.")
            output = true

        }

    }

    //Data
    return output

}

const val EXIT_COMMAND = "exit"
