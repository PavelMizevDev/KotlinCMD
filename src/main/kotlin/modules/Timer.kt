package com.turashift.kotlincmd.modules

fun timer () {

    //Variables\Переменные
    var i = 0

    //Input\Ввод
    println("Start a timer for \n seconds:")
    val readVal = readln()
    val timerVal: Int? = readVal.toIntOrNull()

    //Input processing\Обработка ввода
    if (timerVal != null) {

        //Read cycle\Цикл считывания
        while (true) {

            //Reading seconds\Считывание секунд
            Thread.sleep(1000)
            i++

            //Iteration processing\Обработка итераций
            if (i == timerVal) {

                break

            }

        }

    } else {

        println("Input error: $readVal")

    }

}

const val TIMER_COMMAND = "timer"