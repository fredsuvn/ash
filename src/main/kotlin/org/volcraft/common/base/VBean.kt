package org.volcraft.common.base

import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.javaType

interface VBean {

    fun getSource(): Any?

    fun getProperty(name: String): VProperty?

    fun setProperty(name: String, value: Any?)

    fun get(name: String): Any? = getProperty(name)?.get()

    fun set(name: String, value: Any?) = setProperty(name, value)

    fun getCallable(name: String): VCallable
    fun getCallable(name: String, parameters: Array<Class<*>>)
}

interface VMember {
    val name: String
}

interface VProperty : VMember{
    fun get()

    fun mutable(): Boolean

    fun set(value: Any?)
}

interface VCallable : VMember{
    val parameters: List<Class<*>>
    val returnedType: Class<*>

    fun call(): Any?

    fun call(vararg args: Any): Any?
}





operator fun Any.get(name: String): Any?{
    val p = this::class.memberProperties.first { p->
        p.name == name
    }
    println(p::class)
    return "sss"
}
















class TTT {
    var t1 = "123"
    val t2 = "456"

    fun show(name: String, int: Int) {
        println("show")
    }
}

fun TTT.ext() = 5






fun main(args: Array<String>) {
    val s = TTT()

//    println(s::class.functions)

    s::class.functions.forEach({ f ->
        println(f.parameters)
        for (parameter in f.parameters) {
                println("--->${parameter.name}, ${parameter.kind}, ${parameter.type.javaType}")
        }
    })
}