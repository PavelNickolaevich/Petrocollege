package main.kotlin.oop_pizza

import main.kotlin.oop_pizza.interfaces.Drink

class PizzaPiter(
    neopolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyrolianPizzaPrice: Double
) : PizzaCity(neopolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyrolianPizzaPrice), Drink {

        var isNeopolitanPizzaSale: Boolean = false
        var isRomanPizzaSale: Boolean = false
        var isSicilianPizzaSale: Boolean = false
        var isTyrolianPizzaSale: Boolean = false

    override fun neopolitanPizzaSale() {
        neopolitanPizzaCount++
        isNeopolitanPizzaSale = true
        println("Спасибо за покупку неополитанской пиццы в Санкт-Петербурге")
    }

    override fun romanPizzaSale() {
        romanPizzaCount++
        isRomanPizzaSale = true
        println("Спасибо за покупку римской пиццы в Санкт-Петербурге")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        isSicilianPizzaSale = true
        println("Спасибо за покупку сицилийской пиццы в Санкт-Петербурге")
    }

    override fun tyrolianPizzaSale() {
        tyrolianPizzaCount++
        isTyrolianPizzaSale = true
        println("Спасибо за покупку тирольской пиццы в Санкт-Петербурге")
    }

    override fun calculateSum() {
            money = neopolitanPizzaCount * neopolitanPizzaPrice + romanPizzaCount * romanPizzaPrice +
                    sicilianPizzaCount * sicilianPizzaPrice + tyrolianPizzaCount * tyrolianPizzaPrice

            println("Заработано всего: ${money + sumOfCoffee}")
    }

    override fun calculateAdditionalServicePercent() {
        val total: Double = (countOfWithoutAdditionalService + countOfCoffee).toDouble()

        println("Процент людей купивших кофе: ${(countOfCoffee / total) * 100}\n" +
                "Процент людей НЕкупивших кофе: ${(countOfWithoutAdditionalService / total) * 100}")
    }

    override fun additionalStatistic() {
        println("Продано стаканов кофе: $countOfCoffee")
        println("Продано стаканов кофе на сумму : $sumOfCoffee")
        calculateAdditionalServicePercent()
        calculateCoffeeAndPizza(mapPizza)
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1: Да\n2: Нет")
        if(readLine() == "1") {
            countOfCoffee++
            sumOfCoffee+=200
            checkCountCoffeeForPizza()
            println("С вас 200 рублей")
        } else {
            countOfWithoutAdditionalService++
        }
    }

    private fun checkCountCoffeeForPizza() {
        if (isNeopolitanPizzaSale) {
         //   countOfNepolitanCoffe++
            mapPizza["Неополитанская"] = ++countOfNepolitanCoffe
            isNeopolitanPizzaSale = false
        } else if (isRomanPizzaSale) {
         //   countOfRomanCoffe++
            mapPizza["Римская"] = ++countOfRomanCoffe
            isRomanPizzaSale = false
        } else if (isSicilianPizzaSale) {
         //   countOfCicilianCoffe++
            mapPizza["Сицилийская"] = ++countOfCicilianCoffe
            isSicilianPizzaSale = false
        } else if (isTyrolianPizzaSale ) {
       //     countOfTyrolianCoffe++
            isTyrolianPizzaSale = false
            mapPizza["Тирольская"] = ++countOfTyrolianCoffe
        }
    }

    private fun calculateCoffeeAndPizza(map: Map<String, Int>) {
        val total = map.values.sum().toDouble()
        for (pizza in map ) {
            println("${pizza.key} - ${pizza.value}\nПроценты ${Math.round(pizza.value / total * 100)}")
        }
    }
}