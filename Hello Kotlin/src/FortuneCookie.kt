// Practice with basic functions and lists.

fun main(args: Array<String>) {
    println("Your fortune is : " + getFortuneCookie())
}

fun getFortuneCookie() : String {
    val fortunes : MutableList<String> =
        mutableListOf("Fortune 1", "Fortune 2", "Fortune 3")
    return fortunes[getBirthday() % fortunes.size]
}

fun getBirthday() : Int {
    print("\nEnter your birthday: ")
    return readLine()?.toIntOrNull()?: 1
}