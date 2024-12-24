package main.kotlin.classes.task_3

import kotlin.properties.Delegates

//Выбор наибольшего и наименьшего расстояний (обязательно использовать класс Точка)
//Множество точек расположено на координатной плоскости. Количество точек задается в консоли при запуске программы и
//оно должно быть больше двух. Каждая точка задается своими координатами. Точки не совпадают друг с другом.
//Требуется найти минимальное и максимальное расстояние между точками.


fun main() {

    var condition = true
    var count by Delegates.notNull<Int>()
    while (condition) {
        try {
            println("Введите количество точек более 2-х: ")
            count = readln().toInt()
            if (count < 3) {
                throw Exception()
            } else {
                condition = false
            }
        } catch (e: Exception) {
            println("Введите корректные данные")
        }
    }
    val points: Array<Point?> = arrayOfNulls(count);
    var index = 0

    while (count != 0) {
        println("Ввведите координаты точки X${index + 1}: ")
        val x = readln().toInt()
        println("Ввведите координаты  точки Y${index + 1}: ")
        val y = readln().toInt()
        val point = Point(x, y)
        points[index] = point
        count--
        index++
    }

    for (element in points) {
        print(element.toString())
    }
    println()

    var minDistance = Double.MAX_VALUE
    var maxDistance = Double.MIN_VALUE

    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val d = points[i]!!.distance(points[j]!!)

            if (d < minDistance) {
                minDistance = d
            }
            if (d > maxDistance) {
                maxDistance = d
            }
        }
    }

    println("Минимальное расстояние: $minDistance")
    println("Максимальное расстояние: $maxDistance")
}