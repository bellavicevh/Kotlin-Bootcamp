package Spices
// Practice with interfaces.

abstract class Spice(val name: String, val spiciness: String = "mild"): SpiceColor {
    val heat : Int
        get() = when(spiciness) {
            "mild" -> 0
            "medium" -> 5
            "hot" -> 10
            else -> 0
        }

    init {
        println("New spice: $name created with spiciness level $spiciness ($heat)")
    }

    abstract fun prepareSpice()
}

fun main(args : Array<String>) {
    val curry = Curry("hot")
    println("Curry's color is ${curry.color}")
}

interface Grinder {
    fun grind() {
        println("Grinding spice")
    }
}

interface SpiceColor {
    val color : Color
}

object YellowColor : SpiceColor {
    override val color = Color.YELLOW
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}