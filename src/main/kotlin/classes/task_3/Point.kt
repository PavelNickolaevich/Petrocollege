package main.kotlin.classes.task_3

import kotlin.math.pow
import kotlin.math.sqrt

class Point(x: Int, y: Int) {

    var x: Int = x
    var y: Int = y
    fun distance(other:Point) =  sqrt((x - other.x).toDouble().pow(2) + (y - other.y).toDouble().pow(2))

    override fun toString(): String {
        return "Point(x=$x, y=$y)"
    }


}