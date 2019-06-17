package chap03.section1

fun sum(a: Int, b: Int): Int{
    var sum = a + b
    return sum
}

fun main() {
    var result1 = chap03.section3.sum(3, 2)
    var result2 = chap03.section3.sum(6, 7)

    println(result1)
    println(result2)
}