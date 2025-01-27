package main.kotlin.oop_pizza

import main.kotlin.oop_pizza.interfaces.CheckPhoto
import main.kotlin.oop_pizza.interfaces.Drink
import main.kotlin.oop_pizza.interfaces.Sauce

class PizzaIzhevsk(
    neopolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyrolianPizzaPrice: Double,
    coffeePrice: Int,
    saucePrice: Int
) : PizzaCity(neopolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyrolianPizzaPrice, coffeePrice, saucePrice), Drink, CheckPhoto, Sauce {
    override fun neopolitanPizzaSale() {
        neopolitanPizzaCount++
        println("Спасибо за покупку неополитанской пиццы в Ижевске")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        println("Спасибо за покупку римской пиццы в Ижевске")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("Спасибо за покупку сицилийской пиццы в Ижевске")
    }

    override fun tyrolianPizzaSale() {
        tyrolianPizzaCount++
        println("Спасибо за покупку тирольской пиццы в Ижевске")
    }


    override fun calculateSum() {
        money = neopolitanPizzaCount * neopolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                sicilianPizzaCount * sicilianPizzaPrice + tyrolianPizzaCount * tyrolianPizzaPrice

        println("Заработано всего: ${money + sumOfCoffee - sumOfCheck + sumOfSauce}")
    }

    override fun calculateAdditionalServicePercent() {
        val totalCoffee: Double = (countOfWithoutAdditionalService + countOfCoffee).toDouble()
        val totalPhoto: Double = (countOfWithoutAdditionalService + countOfCheckPhoto).toDouble()

        println("Процент людей показавших чек всего: ${(countOfCheckPhoto / totalPhoto) * 100}\n" +
                "Процент людей НЕпоказавших чек всего: ${(countOfWithoutAdditionalService / totalPhoto) * 100}")

        println("Процент людей купивших кофе: ${(countOfCoffee / totalCoffee) * 100}\n" +
                "Процент людей НЕкупивших кофе: ${(countOfWithoutAdditionalService / totalCoffee) * 100}")
    }

    override fun additionalStatistic() {
        println("Количество соусов сальса: $salsaSouceCount")
        println("Количество соусов барбекю: $barbekySouceCount")
        println("Продано соусов на сумму : $sumOfSauce")
        println("Продано стаканов кофе: $countOfCoffee")
        println("Продано стаканов кофе на сумму : $sumOfCoffee")
        println("Показано чеков: $countOfCheckPhoto")
        println("Показано чеков на сумму : $sumOfCheck")
        calculateAdditionalServicePercent()
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1: Да\n2: Нет")
        if (readLine() == "1") {
            countOfCoffee++
            sumOfCoffee += coffePrice
            println("С вас ${coffePrice} рублей")
        } else {
            countOfWithoutAdditionalService++
        }
    }

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1: Да\n2: Нет")
        if (readLine() == "1") {
            countOfCheckPhoto++
            sumOfCheck += 50
            println("Вам будет скидка 50 рублей с покупки")
        } else {
            countOfWithoutAdditionalService++
        }
        drinkSale()
        chooseSauce()
    }

    override fun chooseSauce() {
        println("Выберите соус ?")
        println("1: Сальса\n2: Барбекю")
        when (readLine()) {
            "1" -> {
                salsaSouceCount++
                println("Вы заказали соус сальса, c вас ${saucePrice} рублей")
            }

            "2" -> {
                barbekySouceCount++
                println("Вы заказали соус барбекю, c вас ${saucePrice} рублей")
            }

            else -> chooseSauce()
        }
        sumOfSauce+=saucePrice
    }
}