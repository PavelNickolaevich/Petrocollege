package main.kotlin.oop_pizza

import main.kotlin.oop_pizza.interfaces.CheckPhoto
import main.kotlin.oop_pizza.interfaces.Drink
import main.kotlin.oop_pizza.interfaces.Sauce
import kotlin.system.exitProcess

fun main() {

    val pizzaPiter = PizzaPiter(175.0, 241.5, 167.5, 215.0)
    val pizzaMoscow = PizzaMoscow(215.0, 250.5, 180.5, 240.0)
    val pizzaIzhevsk = PizzaIzhevsk(100.0, 110.0, 200.0, 210.0, 200, 50)
    var currentPizzaCity: PizzaCity

    while (true) {
    println("Выберите город")
    println("1: Москва\n2: Санкт-Петербург\n3: Ижевск\n0: Выход из программы")

        when (readLine()) {
            "1" -> currentPizzaCity = pizzaMoscow
            "2" -> currentPizzaCity = pizzaPiter
            "3" -> currentPizzaCity = pizzaIzhevsk
            "0" -> break
            else -> {
                println("ERROR")
                continue
            }
        }
        println("Выберите пиццу")
        println("1: Неополитанская пицца\n2: Римская пицца\n3: Сицилийская пицца\n4: Тирольская пицца\n0: Показать статистику")
        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(currentPizzaCity: PizzaCity) {
    when (readLine()) {
        "1" -> {
            currentPizzaCity.neopolitanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "2" -> {
            currentPizzaCity.romanPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "3" -> {
            currentPizzaCity.sicilianPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "4" -> {
            currentPizzaCity.tyrolianPizzaSale()
            selectAddService(currentPizzaCity)
        }
        "0" -> currentPizzaCity.showStatistic()
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizzaCity: PizzaCity) {
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
        is Sauce -> currentPizzaCity.chooseSauce()
    }
}