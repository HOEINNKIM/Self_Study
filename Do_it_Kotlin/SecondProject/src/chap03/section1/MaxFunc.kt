package chap03.section1

fun main() {
    var num1 = 10
    var num2 = 3
    var result: Int

    result = max(num1, num2)
    println(result)
}

fun max(a: Int, b:Int) = if(a>b) a else b