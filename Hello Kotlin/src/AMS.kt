import kotlin.random.Random

// Practice basic operations and control flow in Kotlin.

fun main(args: Array<String>) {
    println("Hello, ${args[0]}!")
    feedTheFish()
    println(fitMoreFish(10, currentFish = listOf(3, 3, 3)))
    println(fitMoreFish(8, listOf(2, 2, 2), hasDecorations = false))
    println(fitMoreFish(9, listOf(1, 1, 3), 3))
    println(fitMoreFish(10, listOf(), 7, true))
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}

fun randomDay() : String {
    val week = listOf("Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday")
    return week[Random.nextInt(7)]
}

fun fishFood(day : String) : String {
    return when(day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun fitMoreFish(gallons : Int,
                currentFish : List<Int>,
                fishSize : Int = 2,
                hasDecorations : Boolean = true) : Boolean {
    return (gallons * if(hasDecorations) .8 else 1.0) - (currentFish.sum() + fishSize) > 0
}