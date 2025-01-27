package main.kotlin.oop_pizza

import main.kotlin.oop_pizza.interfaces.CheckPhoto

class PizzaMoscow(
    neopolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyrolianPizzaPrice: Double
) : PizzaCity(neopolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyrolianPizzaPrice), CheckPhoto {

    override fun neopolitanPizzaSale() {
        neopolitanPizzaCount++
        println("Спасибо за покупку неополитанской пиццы в Москве")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Москве")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Москве")
    }

    override fun tyrolianPizzaSale() {
        tyrolianPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Москве")
    }

    override fun calculateSum() {
        money = neopolitanPizzaCount * neopolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyrolianPizzaCount * tyrolianPizzaPrice

        println("Заработано всего: ${money - sumOfCheck}")
    }

    override fun calculateAdditionalServicePercent() {
        val total: Double = (countOfWithoutAdditionalService + countOfCheckPhoto).toDouble()

       println("Процент людей показавших чек всего: ${(countOfCheckPhoto / total) * 100}\n" +
                "Процент людей НЕпоказавших чек всего: ${(countOfWithoutAdditionalService / total) * 100}")
   }

    override fun additionalStatistic() {
        calculateAdditionalServicePercent()
    }

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1: Да\n2: Нет")
        if(readLine() == "1"){
            countOfCheckPhoto++
            sumOfCheck  +=50
            println("Вам будет скидка 50 рублей с покупки")
        } else {
            countOfWithoutAdditionalService++
        }
    }
}