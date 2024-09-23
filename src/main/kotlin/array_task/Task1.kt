package array_task

//Создать программу, выполняющую следующий функционал:
//- запрашивается количество строк и столбцов для двумерного массива
//- вводится необходимое количество трехзначных чисел (числа могут повторяться)
//- подсчитывается количество различных цифр в полученном массиве
//- на консоль выводится двумерный массив из введенных чисел и количество различных цифр используемых в данном массиве
//Например, для массива
//100   951   101   950
//519   999   155   501
//510   911   144   554
//выведется результат: В массиве использовано 5 различных цифр

fun main() {
    print("Введите количество строк для массива: ")
    val rows = readLine()!!.toInt()
    print("Введите количество столбцов для массива: ")
    val cols = readLine()!!.toInt()
    var count = 0
    var digitArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    var matrix = Array(rows) { IntArray(cols) }
    lateinit var char: CharArray

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            while (true) {
                try {
                    print("Введите трехзначное число ($i, $j): ")
                    val number = readLine()!!.toInt()
                    matrix[i][j] = number

                    if (number < 0) {
                        if (number.toString().length > 4 || number.toString().length < 4) {
                            throw Exception()
                        }
                    } else {
                        if (
                            number.toString().length > 3
                            || number.toString().length < 3
                            || number.toString().startsWith("0")
                        ) {
                            throw Exception()
                        }
                    }

                    char = if (number < 0) {
                        number.toString().split("-")[1].toCharArray()
                    } else {
                        number.toString().toCharArray()
                    }
                    for (n in char.indices) {
                        for (element in digitArray) {
                            if (Character.getNumericValue(char[n]) == element) {
                                digitArray[element] = 666
                                count++
                            }
                        }
                    }
                    break
                } catch (e: Exception) {
                    println("Введено некоррректное число")
                }
            }
        }
    }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print(matrix[i][j].toString() + "\t")
        }
        println()
    }
    println("В массиве испольщовано $count различных цифр")
}
