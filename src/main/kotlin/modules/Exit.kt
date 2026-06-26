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

            output = true

        }
        "N", "n" -> {

            print("Exit cancelled!")
            output = false

        }
        else -> {

            print("Exit cancelled due to user input error.")
            output = false

        }

    }

    //Data
    return output

}

const val EXIT_COMMAND = "exit"
