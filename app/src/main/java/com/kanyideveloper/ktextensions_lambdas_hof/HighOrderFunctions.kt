package com.kanyideveloper.ktextensions_lambdas_hof


/**
 * High order function is a function that takes a function as a parameter or returns a function as a return type
 */

fun main() {
    val numbers = arrayListOf<Int>(23, 45, 65, 78, 90)

    /*for (i in numbers){
        println(i)
    }*/

    //numbers.forEach { n -> println(n) }

    //numbers.forEach { println(it)}

    numbers.forEach (::println )

    //Trailing lambda
    rollDice(1..10, 2) { result ->
        println(result)
    }

}

fun rollDice(range: IntRange, times: Int, callback: (result: Int)-> Unit){
    for (i in 0 until times){
        val result = range.random()
        callback(result)
    }
}

