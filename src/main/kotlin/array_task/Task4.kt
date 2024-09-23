package array_task

import kotlin.math.min

//Задача 4.
//
//Создать приложение, в котором пользователь дает на вход два числовых массива, числа в массиве могут повторяться.
//На выходе приложение выдает пересечение этих массивов. Например, на входе [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2, 2].
//На выходе должны получить [1, 2, 2, 3]. То есть учитывается количество повторений чисел в массиве. Число 2 в одном массиве повторялось два раза,
//в другом - три. Значит в итоговом массиве число два должно быть два раза

fun main() {

    val array1 = arrayOf(1, 2, 3, 2, 0)
    val array2 = arrayOf(5, 1, 2, 7, 3, 2, 2)

    val set1 = hashSetOf<Int>(*array1)
    val set2 = hashSetOf<Int>(*array2)

    val set3 = hashSetOf<Int>()
    val list1 = mutableListOf<Int>()

    for (i in array1) {
        if(set3.contains(i)) {
            list1.add(i)
        } else {
            set3.add(i)
        }
    }

    println(list1)

    val intersect = set1.intersect(set2)
    val union = set1.union(set2)
    val diff = set1.subtract(set2)

    val mut1: MutableList<Int> = mutableListOf(*array1)
    val mut2: MutableList<Int> = mutableListOf(*array2)

    println(mut1.removeAll(mut2))
    println(mut1)

    println(intersect)
    println(union)
    println(diff)



}