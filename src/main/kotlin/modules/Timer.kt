package com.turashift.kotlincmd.modules

import kotlin.concurrent.thread

fun timeManagerFun() {

    val tManager = TimeManager()

    print("Select: Timer - [T/t] or Stopwatch - [S/s] ")
    val select = readln()
    when (select) {

        "T", "t" -> {

            tManager.timer()

        }
        "S", "s" -> {

            tManager.stopwatch()

        }

    }
}

class TimeManager {

    @Volatile private var isRunning = false //Operation flag\Флаг работы
    @Volatile private var timerRunning = false //Operation flag\Флаг работы

    //Timer\Таймер
    fun timer() {

        isRunning = true
        timerRunning = true

        //Seconds request\Запрос секунд
        print("How many seconds to set the timer for: ")
        val seconds = readln().toIntOrNull()

        //Input processing\Обработка ввода
        if (seconds == null) {

            println("Input error! Only integers are allowed!")
            return

        } else if (seconds < 1) {

            println("Input error! At least 1!")
            return

        } else {

            println("Seconds elapsed: $seconds")
            print("Stop? [Y/n] ")

            //New thread\Новый поток
            thread {

                var i = seconds

                //Counting cycle\Цикл отсчета
                while (isRunning) {

                    print("\u001B[s\u001B[1A\r\u001B[2KSeconds elapsed: $i\u001B[u")

                    if (i < 1) {

                        print("\u001B[u\r\u001B[2KTime's up! Press Enter to close!")
                        isRunning = false
                        timerRunning = false
                        break

                    }

                    Thread.sleep(1000)
                    i--

                }

            }

            //Stop key\Ключ остановки
            while (isRunning) {

                val readRunning = readln()

                if (!timerRunning) {

                    return

                }

                isRunning = offTimeManager(readRunning)
                if (!isRunning) return

            }

        }

    }

    //Stopwatch\Секундомер
    fun stopwatch() {

        isRunning = true

        println("Seconds passed: 0")
        print("Stop? [Y/n] ")

        //New thread\Новый поток
        thread {
            var i = 0 //Iteration variable\Переменная для итераций

            //Counting cycle\Цикл отсчета
            while (isRunning) {
                print("\u001B[s\u001B[1A\r\u001B[2KSeconds passed: $i\u001B[u")
                Thread.sleep(1000)
                i++
            }

        }

        //Stop key\Ключ остановки
        while (true) {
            val readRunning = readln()
            isRunning = offTimeManager(readRunning)
            if (!isRunning) return
        }

    }

    //Stop confirmation\Подтверждение остановки
    fun offTimeManager (command: String) : Boolean {

        var bool: Boolean

        //Command processing\Обработка команды
        if (command == "Y" || command == "y") {

            bool = false
            println("\u001B[u\r\u001B[2KStop process")

        } else {

            bool = true
            print("\u001B[u\r\u001B[2KStop? [Y/n] ")

        }

        return bool

    }

}

const val TIMER_MANAGER_COMMAND = "tM"
