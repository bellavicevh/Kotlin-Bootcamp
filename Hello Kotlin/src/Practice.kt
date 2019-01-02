// File to hold small practices in course.

fun main(args : Array<String>) {
    // whatShouldIDoToday("happy")

    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.modify { rem(3) == 0 })
}

// Practice with one-line functions and readable code.
fun isNiceWeather(mood : String, weather : String, temperature : Int) =
    mood == "happy" && weather == "sunny" && temperature < 30

fun inBadMood(mood : String) = mood == "grumpy"

fun isWarmDay(mood : String, temperature : Int) = mood == "happy" && temperature > 30

fun isSnowDay(weather : String) = weather == "snowy"

fun whatShouldIDoToday(weather : String = "sunny",
                        temperature : Int = 24) : String {
    val mood = readLine()!!
    return when {
        isNiceWeather(mood, weather, temperature) -> "go for a walk"
        inBadMood(mood) -> "mope"
        isWarmDay(mood, temperature) -> "go to the beach"
        isSnowDay(weather) -> "have a snowball fight"
        else -> "stay home and read"
    }
}

// Practice with higher-order functions.
fun List<Int>.modify(block : Int.() -> Boolean) : List<Int> {
    val result = mutableListOf<Int>()
    for(element in this) {
        if(element.block()) result.add(element)
    }
    return result
}

