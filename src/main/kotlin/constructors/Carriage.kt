package main.kotlin.constructors

class Carriage(private val direction: String, private val countOfWagon: Int) {

    override fun toString(): String {
        return "Поезд ${direction}, состоящий из $countOfWagon вагонов отправлен!"
    }
}