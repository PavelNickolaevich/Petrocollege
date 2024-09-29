package main.kotlin.function.rock_paper_scissors

import java.lang.Character.UnicodeBlock
import java.util.*
import javax.xml.stream.events.Characters
import kotlin.random.Random

//Биграммный шифр Порты
//Создать программу, для шифровки и расшифровки сообщений. Программа запрашивает исходное сообщение,
// вспомогательный символ и спрашивает - использовать типовую таблицу или генерировать случайную.
// Типовая таблица предоставлена на экране. При генерации случайной таблицы каждой паре букв сопоставляется случайное
// число от 1 до 999. Числа в таблице не повторяются. Каждое число состоит из трех знаков.
// Если число меньше 100, то оно дописывается до трех знаков путем добавления нулей перед числом.
//
//В результате работы на консоль выводится исходное сообщение разбитое по парам букв с пробелами между парами,
// зашифрованное сообщение состоящее из цифр разбитых в группы по три цифры и пробела между группами и шифровальная таблица.
// Группа цифр из зашифрованного сообщения пишется под соответствующей парой символов исходного сообщения.
//
//Шифр Порты, представленный им в виде таблицы, является первым известным биграммным шифром.
// Размер его таблицы составлял 20 х 20 ячеек; наверху горизонтально и слева вертикально записывался стандартный алфавит
// (в нем не было букв J, К, U, W, X и Z). В ячейках таблицы могли быть записаны любые числа, буквы или символы -
// сам Джованни Порта пользовался символами - при условии, что содержимое ни одной из ячеек не повторялось.
// Применительно к русскому языку таблица шифрозамен может выглядеть следующим образом.


fun main() {
    val alphabet = listOf(
        "а", "б", "в", "г", "д", "е", "ж", "з", "и", "к", "л", "м", "н", "о", "п", "р", "с",
        "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"
    ).mapIndexed { index, letter -> letter to index }.toMap()
    while (true) {
        try {
            println("Введите исходное сообщение кириллицей")
            var message = readln().lowercase(Locale.getDefault())
            for (i in message.indices) {
                if (isCyrillicAlphabet(message[i]) == false) {
                    throw Exception()
                }
            }
            println("Введите вспомогательны символ")
            val symbol = readln().single()
            println("Использовать типовую таблицу или генерировать случайную? да/нет")
            val makeDecision = readln()
            val genArray = when (makeDecision) {
                "да" -> getDefaultTable(alphabet.keys.toList())
                "нет" -> generateTableInt(alphabet.keys.toList())
                else -> {
                    throw Exception()
                }
            }
            if (message.length % 2 != 0) {
                message += symbol
            }
            val posRows = mutableListOf<Int>()
            val posColumn = mutableListOf<Int>()
            for (m in message.indices) {
                if (alphabet.containsKey(message[m].toString())) {
                    val position = alphabet.getValue(message[m].toString())
                    if (m % 2 == 0) {
                        posRows.add(position)
                    } else {
                        posColumn.add(position)
                    }
                }
            }
            val listOfCypher = mutableSetOf<String>()
            for (n in posRows.indices) {
                if (genArray[posRows[n]][posColumn[n]] in 1..99) {
                    listOfCypher.add(genArray[posRows[n]][posColumn[n]].toString().padStart(3, '0'))
                } else {
                    listOfCypher.add(genArray[posRows[n]][posColumn[n]].toString())
                }
            }
            val result = message.mapIndexed { index, char ->
                if (index % 2 == 0) "$char${message[index + 1]}" else ""
            }
            println("Исходное:\t ${result.joinToString(" ")}\n \tШифр:\t ${listOfCypher.joinToString(" ")}")
            break
        } catch (e: Exception) {
            println("Введены некорректные данные")
        }
    }
}

fun isCyrillicAlphabet(c: Char) = c in 'а'..'я' || c in 'А'..'Я'

fun getDefaultTable(alphabet: List<String>): Array<IntArray> {
    var table = Array(31) { IntArray(31) }
    var num = 1
    print("\n\t")
    for (i in alphabet) {
        print(i + "\t")
    }
    println()
    for (i in alphabet.indices) {
        print("${alphabet[i]}|\t")
        for (j in 0..30) {
            table[i][j] = num
            if (table[i][j] in 1..99) {
                print(table[i][j].toString().padStart(3, '0') + "\t")
            } else {
                print(table[i][j].toString() + "\t")
            }
            num++
        }
        println()
    }
    return table
}

fun generateTableInt(alphabet: List<String>): Array<IntArray> {
    val table = Array(31) { IntArray(31) }
    print("\n\t")
    for (i in alphabet) {
        print(i + "\t")
    }
    println()
    for (i in alphabet.indices) {
        print("${alphabet[i]}|\t")
        for (j in alphabet.indices) {
            table[i][j] = checkNum()
            if (table[i][j] in 1..99) {
                print(table[i][j].toString().padStart(3, '0') + "\t")
            } else {
                print(table[i][j].toString() + "\t")
            }
        }
        println()
    }
    return table
}

fun generateNum(): Int = Random.nextInt(999) + 1

fun checkNum(): Int {
    val listOfNum = mutableListOf<Int>()
    var checkNum = generateNum()
    if (listOfNum.contains(checkNum)) {
        checkNum = generateNum()
    } else {
        listOfNum.add(checkNum)
    }
    return checkNum
}


