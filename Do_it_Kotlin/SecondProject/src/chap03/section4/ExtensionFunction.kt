package chap03.section4

fun main() {
    val source = "Hello World!"
    var target = "kotlin"
    println(source.getLongString(target))
}

fun String.getLongString(target: String): String =
        if(this.length > target.length) this else target