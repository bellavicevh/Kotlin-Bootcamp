package Spice

class SimpleSpice {
    val name : String = "curry"
    val spiciness: String = "mild"
    val heat : Int
        get() = if(spiciness == "mild") 5 else 0
}