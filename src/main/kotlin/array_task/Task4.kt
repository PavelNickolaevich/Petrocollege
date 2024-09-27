package array_task

//Задача 4.
//
//Создать приложение, в котором пользователь дает на вход два числовых массива, числа в массиве могут повторяться.
//На выходе приложение выдает пересечение этих массивов. Например, на входе [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2, 2].
//На выходе должны получить [1, 2, 2, 3]. То есть учитывается количество повторений чисел в массиве. Число 2 в одном массиве повторялось два раза,
//в другом - три. Значит в итоговом массиве число два должно быть два раза

fun main() {

    val resultList = mutableListOf<Int>()
    var list1: List<Int>? = null
    var list2: List<Int>? = null
    var isCheck = true
    while (isCheck) {
        try {
            println("Введите значения первого массива через пробел")
            list1 = readln().split(' ').map { it.toInt() }.toList()
            println("Введите значения второго массива через пробел")
            list2 = readln().split(' ').map { it.toInt() }.toList()
            isCheck = false
        } catch (e: Exception) {
            println("Введены некорректные значения")
        }
    }

    val countMap = mutableMapOf<Int, Int>()
    for (element in list1!!) {
        if (list2!!.contains(element)) {
            val currentCount = countMap[element] ?: 0
            countMap[element] = currentCount + 1
        }
    }

    for (i in countMap.keys) {
        for (j in 1..countMap[i]!!) {
            resultList.add(i)
        }
    }

    println("Итоговый массив:")
    resultList.forEach { print("$it") }
}