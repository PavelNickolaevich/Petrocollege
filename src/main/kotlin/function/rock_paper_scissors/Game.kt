package main.kotlin.function.rock_paper_scissors

import kotlin.random.Random

class Computer {
    private val variant = arrayOf("камень", "ножницы", "бумага")
    private  val rand = Random.nextInt(variant.size)
    val compVal = variant[rand]
}

class Player {
    val manVar = readLine().toString().lowercase()
}

fun main() {
    val notif = "Введите корректное значение";
    println("Добро пожаловать в игру Камень-Ножницы-Бумага")

    while(true) {
        println("Начать игру - 1 \nВыйти из игры  - 2")
        try {
            val inNum = readLine()!!.toInt();
            when (inNum) {
                1 -> {
                    println("Компьютер загадал вариант")
                    println("Введите: камень, ножницы или бумага")
                    while (true) {
                        val compVar = Computer().compVal
                        val player = Player().manVar
                        if(!playGame(compVar, player)) {
                            break
                        }
                    }
                }
                2 -> break
                else -> println("Введены некорреткные данные")
            }
        } catch (e: Exception) {
            println("Введены некорреткные данные")
        }
    }

}

fun playGame(computer: String, player: String): Boolean {
    var isWrongValue: Boolean  = false
    when(player) {
        "камень" -> when(computer) {
            "бумага" -> println ("Вы проиграли, компьютер загадал: $computer\n")
            "ножницы" -> println ("Вы победили, компьютер загадал: $computer\n")
             else -> println ("Ничья, компьютер загадал: $computer\n")
        }
        "бумага" -> when(computer) {
            "ножницы" -> println ("Вы проиграли, компьютер загадал: $computer\n")
            "камень" -> println ("Вы победили, компьютер загадал: $computer\n")
            else -> println ("Ничья, компьютер загадал: $computer\n")
        }
        "ножницы" -> when(computer) {
            "бумага" -> println ("Вы победили, компьютер загадал: $computer\n")
            "камень" -> println ("Вы проиграли, компьютер загадал: $computer\n")
            else -> println ("Ничья, компьютер загадал: $computer\n")
        }
        else -> {
            println("Введите корректное значение")
             isWrongValue = true;
        }
    }
    return isWrongValue
}
