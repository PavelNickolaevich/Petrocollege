package main.kotlin.classes.task_5

import main.kotlin.classes.task_5.Point
import main.kotlin.classes.task_4.Triangle

//Окружность в треугольнике (обязательно использование класса Точка и класса Треугольник. Класс Окружность и другие классы - по желанию)
//Треугольник расположен на координатной плоскости и описан координатами своих вершин.
//Написать программу вычисляющую координаты центра вписанной в треугольник окружности и ее радиус.

fun main() {

    println("Введите координаты точек треугольника: ")

    var condition = 0
    val points: Array<Point?> = arrayOfNulls(3);
    while (condition < 3) {
        println("Ввведите координаты точки X${condition + 1}: ")
        val x = readln().toInt()
        println("Ввведите координаты  точки Y${condition + 1}: ")
        val y = readln().toInt()
        val point = Point(x, y)
        points[condition] = point
        condition++
    }

    val triangle = Triangle(points[0]!!, points[1]!!, points[2]!!)

    // Если площадь равна нулю, то вершины совпадают и вписать окружность нельзя
    if (triangle.area.toDouble() == 0.0) {
        throw IllegalArgumentException("Все точки совпадают, вписать окружность невозможно")
    } else {
        println(triangle.centroid)
        println(triangle.radius)
    }


}