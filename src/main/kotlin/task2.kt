//Создать приложение, которое подсчитывает количество различных символов во введенной строке.
//Символы в ответе расположить в алфавитном порядке. Например, дана строка AASADDSS. На выходе получаем:
//A - 3
//D - 2
//S - 3

fun main() {

    // val inputString = "AASADDSS"
    println("Введите строку")
    val inputString = readLine().toString().uppercase()
    var result = ""
    var count = 1
    val sortString = inputString.toCharArray().sorted().joinToString("")
    var currentChar = sortString[0]

    for (i in 1 until sortString.length) {
        if (sortString[i] == currentChar) {
            count++
        } else {
            result += "${currentChar} - $count\n"
            currentChar = sortString[i]
            count = 1
        }
    }
    result += "${currentChar} - $count\n"
    println(result)
}