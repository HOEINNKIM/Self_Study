package chap03.section5

fun main() {
    var multi = 3 multiply 10
    println("multi : $multi")
}

infix fun Int.multiply(x: Int): Int{
    return this * x
}