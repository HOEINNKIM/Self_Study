package chap02.section1

import com.example.edu.Person as User

fun main() {
    var user1 = User("Hoe", 27)
    var user2 = Person("A123", "Kildong")

    println(user1.name)
    println(user1.age)

    println(user2.id)
    println(user2.name)

}

class Person(var id: String, val name: String)