import kotlin.random.Random

// Practice with constants and extension functions.

const val MAX_BOOKS = 3

open class Book(val title : String, val author : String, val year : Int) {
    var currentPage = 0
    var pages = 0

    open fun readPage() { currentPage++ }

    fun getTitleAndAuthor() : Pair<String, String> {
        return title to author
    }

    fun getProperties() : Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(numBorrowed : Int) : Boolean {
        return numBorrowed < MAX_BOOKS
    }

    fun printUrl() {
        println("$BASE_URL/$title.html")
    }

    companion object {
        const val BASE_URL = "library.org"
    }
}

fun Book.weight() : Double { return pages.times(1.5) }

fun Book.tornPages(tornPages : Int) { if(pages >= tornPages) pages -= tornPages else pages = 0}

class EBook(title : String, author : String, year : Int, val format : String = "text")
    : Book(title, author, year) {
    override fun readPage() { currentPage += 250}
}

class Puppy {
    fun playWithBook(book : Book) {
        book.tornPages(Random.nextInt(book.pages + 1))
    }
}

fun main(args : Array<String>) {
    val myBook = Book("The Sorcerer's Stone", "JK Rowling", 1994)
    val (title, author, year) = myBook.getProperties()
    println("Here is $title written by $author in $year")
    val (title2, author2) = myBook.getTitleAndAuthor()
    println("$title2, $author2")

    val allBooks = setOf<String>("Romeo and Juliet", "Midsummer Night's Dream", "Hamlet")
    val library = mapOf(allBooks to "Shakespeare")
    val ham = library.any { it.key.contains("Hamlet") }
    println("Hamlet is in the libray: $ham")
    val moreBooks = mutableMapOf<String, String>()
    val get = moreBooks.getOrPut("Hamlet") { "Shakespeare" }
    println("What does get or put return? $get")

    // Test out extension functions.
    myBook.pages = 15
    val fluffy = Puppy()
    while(myBook.pages > 0) {
        fluffy.playWithBook(myBook)
        println("There are ${myBook.pages} pages left.")
    }
}