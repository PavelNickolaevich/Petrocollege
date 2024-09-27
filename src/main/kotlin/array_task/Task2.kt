package array_task

//Задача 2.
//
//Имеется массив целых чисел из 5-и строк и 5-и столбцов. Выяснить, симметричен ли он относительно главной диагонали.
// То есть - элемент 1,2 равен элементу 2,1. Элемент 1,3 равен элементу 3,1 и т.д. Например массив
//5  9  6  7  2
//9  8  4  5  3
//6  4  3  8  7
//7  5  8  4  8
//2  3  7  8  1
//является симметричным относительно главной диагонали

fun main() {
    val rows = 5
    val cols = 5
    val matrix = Array(rows) { IntArray(cols) }

//    val table: Array<Array<Int>> = Array(3) { Array(3) { 0 } }
//    table[0] = arrayOf(5, 9, 6, 7, 2)
//    table[1] = arrayOf(9, 8, 4, 5, 3)
//    table[2] = arrayOf(6, 4, 3, 8, 7)
//    table[3] = arrayOf(7, 5, 8, 4, 8)
//    table[4] = arrayOf(2, 3, 7, 8, 1)

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print("Введите число ($i, $j): ")
            val number = readLine()!!.toInt()
            matrix[i][j] = number
        }
    }

    for (i in 0 until rows) {
        for (j in 1 until cols) {
            if (matrix[i][j] == matrix[j][i])
                continue
            else {
                println("Матрица не симметричная")
                break
            }
        }
    }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            print(matrix[i][j].toString() + "\t")
        }
        println()
    }

}