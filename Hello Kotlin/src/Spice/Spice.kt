package Spice
// Practice overriding getters.

class Spice(val name: String, val spiciness: String = "mild") {
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
}