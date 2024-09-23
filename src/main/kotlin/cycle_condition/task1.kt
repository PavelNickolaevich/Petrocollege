//Создать приложение, которое подсчитывает количество подряд идущих одинаковых символов во введенной строке. На вход подается,
//например, строка AAADSSSRRTTHAAAA. На выходе получаем A3DS3R2T2HA4. То есть, если количество подряд идущих символов меньше двух,
//то мы не пишем единицу

fun main() {
    // val inputString = "AAADSSSRRTTHAAAA"
    // val inputString = "AAADSSSRRTTHA"
    println("Введите строку")
    val inputString = readLine().toString().uppercase()
    var result = ""
    var currentChar = inputString[0]
    var count = 1

    for (i in 1 until inputString.length) {
        if (inputString[i] == currentChar) {
            count++
        } else {
            if (count > 1) {
                result += "$currentChar$count"
            } else if (count == 1) {
                result += "$currentChar"
            }
            currentChar = inputString[i]
            count = 1
        }
    }
    result += if (count == 1) {
        "$currentChar"
    } else {
        "$currentChar$count"
    }
    println(result)
}

