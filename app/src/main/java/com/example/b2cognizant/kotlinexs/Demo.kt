package com.example.b2cognizant.kotlinexs

class Demo {
}

fun printHello() {
    println("Hello World")
    var rocks: Int? = null

}

fun foo(
    bar: Int = 0,
    baz: Int,
) { /*...*/ }

fun countFish(fish:Int){
    when (fish) {
        0  -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }
}

fun main1() {
    foo(baz= 10)
    countFish(28)
    var a:Int = 10
    var name = "ansari"
    var i: Int = 6
    i= 10
   // printHello()
   // print(2.times(3))
    print(1 into 2)

}

fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    //return Unit
    //or `return` is optional
}

fun double(x: Int): Int =  x * 2

infix fun Int.into(x: Int): Int { return  x *2 }

//{ a, b -> a + b }

fun add(a:Int,b:Int) = a+b

fun calculate(x: Int,
              y: Int,
              operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sum(x: Int, y: Int) = x + y                                     // 3
fun mul(x:Int, y:Int) = x*y

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5 ,{ a, b -> a * b } )            // 5
    println("sumResult $sumResult, mulResult $mulResult")
}

