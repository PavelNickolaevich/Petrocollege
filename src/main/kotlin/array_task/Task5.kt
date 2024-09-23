package array_task

import java.util.*

//Задача 5.
//
//Создать приложение, в котором пользователь вводит массив из различных слов.
// На выходе приложение должно показать слова сгруппированные по признаку "состоят из одинаковых букв".
// Например, на входе ["eat", "tea", "tan", "ate", "nat", "bat"]. Получаем группы:
//"ate", "eat", "tea"
//"nat", "tan"
//"bat"


fun main() {

//    val wordArr = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

    val words = mutableListOf<String>()

    while (true) {
        print("Введите слово или пустое значение для выполнение программы:")  // Ввод слова с клавиатуры
        val word = readLine().toString()
        if (word.isEmpty()) break
        words.add(word)
    }

    val groupedWords = words.groupBy { it.toCharArray().sorted().joinToString("") }

    groupedWords.forEach{entry ->
        println(entry.value.joinToString(", "))
    }

}