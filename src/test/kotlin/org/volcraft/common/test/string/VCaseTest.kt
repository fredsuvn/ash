package org.volcraft.common.test.string

import org.volcraft.common.base.NamingCase

fun main(args: Array<String>) {
    val test1 = "AAAAaaaa"
    val test2 = "ThisIsAApple0908"
    val test3 = "AAAAaaaaAA"

    println(NamingCase.LOWER_CAMEL.to(NamingCase.UPPER_CAMEL, test2))

    println(NamingCase.UPPER_CAMEL.to(NamingCase.LOWER_CAMEL, test2))

    println(NamingCase.LOWER_CAMEL.to(NamingCase.UPPER_CAMEL, test2))

    println(NamingCase.UPPER_CAMEL.to(NamingCase.LOWER_CAMEL, test2))

    println(NamingCase.LOWER_CAMEL.to(NamingCase.UPPER_HYPHEN, test2))

    println(NamingCase.UPPER_CAMEL.to(NamingCase.LOWER_UNDERSCORE, test2))
}

class AAA{
    constructor(vararg s: String){
        dododo(s as String)
    }

}

fun dododo(vararg s: String) {
    println(s)
}

//fun dododo(s: String) {
//    println(s)
//}