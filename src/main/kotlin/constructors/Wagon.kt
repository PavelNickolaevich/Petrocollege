package main.kotlin.constructors

import kotlin.random.Random

data class Wagon(var capacity: Int = 0, var num: Int = 1) {

    fun fillWagon(capacity: Int): List<Wagon> {
        val listOfWagons = mutableListOf<Wagon>()
        var passanger = capacity
        while(passanger > 0) {
            val wagonCapacity = Random.nextInt(5, 25)
            listOfWagons.add(Wagon(wagonCapacity, num++))
            passanger -= wagonCapacity
        }
        return listOfWagons;
    }
}