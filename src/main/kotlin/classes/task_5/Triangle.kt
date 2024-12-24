package main.kotlin.classes.task_5


import kotlin.math.abs
import kotlin.math.sqrt

class Triangle(private val a: Point, private val b: Point, private val c: Point) {

    // Найдем площадь треугольника
    val area = abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2

    // Координаты центра тяжести треугольника
    val centroidX = (a.x + b.x + c.x) / 3
    val centroidY = (a.y + b.y + c.y) / 3
    val centroid = Point(centroidX, centroidY)

    // Периметр треугольника
    val perimeterX = abs(a.x - b.x) + abs(b.x - c.x) + abs(c.x - a.x)
    val perimeterY = abs(a.y - b.y) + abs(b.y - c.y) + abs(c.y - a.y)
    val perimeter = sqrt((perimeterX * perimeterX + perimeterY * perimeterY).toDouble())

    // Радиус вписанной окружности
    val radius = perimeter / 2

}