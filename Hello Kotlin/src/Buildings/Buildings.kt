package Buildings

// Practice with generics.

open class BaseBuildingMaterial(val numberNeeded : Int = 1)

class Wood : BaseBuildingMaterial(4)

class Brick : BaseBuildingMaterial(8)

class Building<out T : BaseBuildingMaterial>(private val material : T) {
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = 100.times(material.numberNeeded)

    fun build() {
        println("We need $actualMaterialsNeeded items of ${material::class.simpleName}")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building : Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("small building")
    else println("large building")
}

fun main(args : Array<String>) {
    val myBuilding = Building(Wood())
    myBuilding.build()
}