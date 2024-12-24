package main.kotlin.constructors

import kotlin.random.Random

class Direction() {

    var listOfCities: MutableList<String> = mutableListOf(
        "Москва", "Ижевск", "Питер", "Сочи", "Хабаровск",
        "Владимир", "Пермь", "Сарапул", "Ялта", "Новосибирск", "Магадан", "Владивосток",
        "Томск", "Тверь", "Туапсе")

    fun getDirection(): String {
        val departure = listOfCities[Random.nextInt(0, listOfCities.size)]
        listOfCities.remove(departure)
        val destination = listOfCities[Random.nextInt(0, listOfCities.size)]
        listOfCities.add(departure)
        return "$departure - $destination"
    }
}