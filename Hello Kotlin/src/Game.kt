// Practice with lambdas.

enum class Directions {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Directions.START)
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }
    val end = {
        path.add(Directions.END)
        println("Game Over")
        println(path)
        path.clear()
         false
    }

    private fun move(where : () -> Unit) {
        where()
    }

    fun makeMove(str : String?) {
        when(str) {
            "n" -> move { north() }
            "s" -> move { south() }
            "e" -> move { east() }
            "w" -> move { west() }
            else -> move { end() }
        }
    }
}

fun main(args : Array<String>) {
    val myGame = Game()
    println(myGame.path)
    myGame.north()
    myGame.east()
    myGame.south()
    myGame.west()
    myGame.end()
    println(myGame.path)

    while(true) {
        print("Enter a direction: n/s/e/w")
        myGame.makeMove(readLine())
    }
}