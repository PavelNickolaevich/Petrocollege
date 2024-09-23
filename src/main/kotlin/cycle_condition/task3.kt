//Создать приложение, которое преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную.
fun main() {

    while (true) {
        try {
            println("Введите натуральное число")
            var number = readLine()!!.toUInt().toInt()

            var remainder: Int;
            var stringNum = ""
            var reversString = "";
            while (number != 0) {
                remainder = number % 2;
                number /= 2;
                stringNum += remainder
            }
            for (i in stringNum.length - 1 downTo 0) {
                reversString += stringNum[i].toString()
            }
            println(reversString)
        } catch (e: Exception) {
            println("Введены некорреткные данные")
        }
    }

}