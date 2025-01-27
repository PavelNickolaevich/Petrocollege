package main.kotlin.oop_pizza


abstract class PizzaCity (
    protected val neopolitanPizzaPrice: Double, protected val romanPizzaPrice: Double,
    protected val sicilianPizzaPrice: Double, protected val tyrolianPizzaPrice: Double
) {

    protected var countOfNepolitanCoffe = 0
    protected var countOfRomanCoffe = 0
    protected var countOfCicilianCoffe = 0
    protected var countOfTyrolianCoffe = 0
    protected var neopolitanPizzaCount: Int = 0
    protected var romanPizzaCount: Int = 0
    protected var sicilianPizzaCount: Int = 0
    protected var tyrolianPizzaCount: Int = 0
    protected var countOfCoffee: Int = 0
    protected var countOfCheckPhoto: Int = 0
    protected var sumOfCoffee: Int = 0
    protected var sumOfCheck: Int = 0
    protected var money: Double = 0.0
    protected var countOfWithoutAdditionalService: Int = 0
    protected var salsaSouceCount = 0
    protected var barbekySouceCount = 0
    protected var sumOfSauce = 0

    var coffePrice: Int = 0
    var saucePrice: Int = 0

    constructor(
        neopolitanPizzaPrice: Double,
        romanPizzaPrice: Double,
        sicilianPizzaPrice: Double,
        tyrolianPizzaPrice: Double,
        coffePrice: Int,
        saucePrice: Int) : this(neopolitanPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyrolianPizzaPrice) {
        this.coffePrice = coffePrice
        this.saucePrice = saucePrice
    }

    var mapPizza = mutableMapOf(
        "Неополитанская" to 0 ,
        "Римская" to 0,
        "Сицилийская" to 0,
        "Тирольская" to 0)

    abstract fun neopolitanPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyrolianPizzaSale()
    abstract fun calculateSum()
    abstract fun calculateAdditionalServicePercent()

    abstract fun additionalStatistic()

    fun showStatistic() {
        println("Продано неополитанской пиццы: $neopolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано сицилийской пиццы: $sicilianPizzaCount")
        println("Продано тирольской пиццы: $tyrolianPizzaCount")
        calculateSum()
        additionalStatistic()
    }

}