package com.turashift.kotlincmd.modules

import kotlin.concurrent.thread

//StartFunction
fun timeManagerFun() {

    val tManager = TimeManager() //Connecting a class

    print("Select: Timer - [T/t] or Stopwatch - [S/s] ")
    val select = readln()

    //CommandProcessing
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

    //Flags
    //`@Volatile` ensures that changes to a variable by one thread are instantly visible to all other threads.
    @Volatile private var isRunning = false
    @Volatile private var timerRunning = false

    fun timer() {

        isRunning = true
        timerRunning = true

        print("How many seconds to set the timer for: ")
        var i = readln().toIntOrNull()

        //CommandProcessing
        if (i == null) {

            println("Input error! Only integers are allowed!")
            return

        } else if (i < 1) {

            println("Input error! At least 1!")
            return

        } else {

            println("")
            print("Stop? [Y/n] ")

            //Needed for multi-threading so that during counting you can stop the counting
            thread {

                while (isRunning) {

                    //Calculation of variables using the Day.Hour:Minute:Second format
                    val s = i % 60 //Seconds
                    val m = (i / 60) % 60 //Minutes
                    val h = (i / 3600) % 24 //Hours
                    val d = i / 86400 //Days

                    print("\u001B[s\u001B[1A\r\u001B[2KTime left: ${d}D.${h}H:${m}M:${s}S [ ${i}S ]\u001B[u")

                    //Processing to ensure that the timer does not go into minus
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

            //StopKey
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

    fun stopwatch() {

        isRunning = true

        //Called the output in advance for it to work correctly
        println("")
        print("Stop? [Y/n] ")

        //Needed for multi-threading so that during counting you can stop the counting
        thread {

            var i: Long = 0

            while (isRunning) {

                //Calculation of variables using the Day.Hour:Minute:Second format
                val s = i % 60 //Seconds
                val m = (i / 60) % 60 //Minutes
                val h = (i / 3600) % 24 //Hours
                val d = i / 86400 //Days

                print("\u001B[s\u001B[1A\r\u001B[2KTime passed: ${d}D.${h}H:${m}M:${s}S [ ${i}S ]\u001B[u")

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

    //StopConfirmation
    fun offTimeManager (command: String) : Boolean {

        var bool: Boolean

        //CommandProcessing
        if (command == "Y" || command == "y") {

            bool = false
            println("\u001B[u\r\u001B[2KTimeManager has stopped!")

        } else {

            bool = true
            print("\u001B[u\r\u001B[2KStop? [Y/n] ")

        }

        return bool

    }

}

const val TIMER_MANAGER_COMMAND = "tmanag"
