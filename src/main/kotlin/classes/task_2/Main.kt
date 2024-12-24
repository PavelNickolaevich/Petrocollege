package main.kotlin.classes.task_2

import kotlin.math.pow
import kotlin.math.sqrt

//Две точки находятся на координатной плоскости.
//Каждая точка описана своими координатами. Найти расстояние между указанными точками.

fun main() {
    while (true) {
        try {
            println("Ввведите координаты  первой точки X1: ")
            val x1 = readln().toInt()
            println("Ввведите координаты  первой точки Y1: ")
            val y1 = readln().toInt()
            println("Ввведите координаты  первой точки X2: ")
            val x2 = readln().toInt()
            println("Ввведите координаты  первой точки Y2: ")
            val y2 = readln().toInt()
            val point1 = Point(x1, y1)
            val point2 = Point(x2, y2)

            val distance = sqrt((point2.x - point1.x).toDouble().pow(2) + (point2.y - point1.y).toDouble().pow(2))
            println("Расстоние между точками: $distance")
            println("Введеите exit для выхода")
            if (readln().toString() == "exit") {
                break
            }
        } catch (e: Exception) {
            println("Введены некорректные данные")
        }
    }
}