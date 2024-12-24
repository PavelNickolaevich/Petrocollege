package main.kotlin.classes.task_1

//Точка и треугольник (создать класс Точка и класс Треугольник)
//Треугольник описан координатами трех своих вершин. Указаны координаты отдельной точки.
// Составить программу, показывающую где находится точка - внутри или вне треугольника.
// Треугольник и точка находятся на координатной плоскости.
//
//Обратить внимание на обработку ошибок при вводе координат. Программа не должна "падать" при вводе неправильных значений.


    fun main() {

        var point = Point(2, 2)
        println("Введите координаты точки x и y")
        val x = readln().toIntOrNull() ?: throw IllegalArgumentException("rvrb")
        val y = readln().toIntOrNull() ?: throw IllegalArgumentException("rvrb")
        println("Введите координаты точек треугольника: ")

        var condition = 0
        val points: Array<main.kotlin.classes.task_5.Point?> = arrayOfNulls(3);
        while (condition < 3) {
            println("Ввведите координаты точки X${condition + 1}: ")
            val x = readln().toInt()
            println("Ввведите координаты  точки Y${condition + 1}: ")
            val y = readln().toInt()
            val point = main.kotlin.classes.task_5.Point(x, y)
            points[condition] = point
            condition++
        }

        val triangle = main.kotlin.classes.task_5.Triangle(points[0]!!, points[1]!!, points[2]!!)

    }
