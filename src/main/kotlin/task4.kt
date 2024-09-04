import java.util.*

//Создать приложение, с помощью которого пользователь, введя два числа и символ операции,
//узнает результат. Символами операции могут быть: / — деление, * — умножение, + — сложение, - — вычитание.
//Числа могут быть вещественными. Числа и знак операции разделяются между собой одним пробелом.
//Ввод производится в формате - ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ

fun main() {

    val scanner = Scanner(System.`in`)
    println("Введите два числа и операцию между ними. Или введите exit для выхода")
    while (true) {
        try {
            val input = scanner.nextLine()
            if(input.equals("exit")) {
                break
            }
            val parts = input.split(" ")
            if (parts.size != 3) {
                println("Неверный формат ввода. Введите два числа и операцию между ними. Или введите exit для выхода")
                continue
            }
            val num1 = parts[0].toDouble()
            val num2 = parts[1].toDouble()
            val operator = parts[2]

            when (operator) {
                "/" -> println("Результат: ${num1 / num2}")
                "*" -> println("Результат: ${num1 * num2}")
                "+" -> println("Результат: ${num1 + num2}")
                "-" -> println("Результат: ${num1 - num2}")
                else -> println("Недопустимый оператор. Введите все заново Или введите exit для выхода")
            }

        } catch (e: Exception) {
            println("Ошибка ввода. Пожалуйста, введите два числа и допустимую операцию. Или введите exit для выхода")
        }
    }
}