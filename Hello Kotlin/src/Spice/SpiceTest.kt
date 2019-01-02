package Spice

fun main(args: Array<String>) {
    val mySpice = SimpleSpice()
    println("${mySpice.name} has heat ${mySpice.heat}")

    val filtered = spiceList().filter { it.heat >= 5 }.map { it.name }
    println("filtered list: $filtered")
}

fun spiceList() : List<Spice> {
    return listOf(Spice("Pepper"),
        Spice("Salt"),
        Spice("Red Pepper", "medium"),
        Spice("Cayenne", "hot"),
        Spice("Red Curry", "hot"))
}