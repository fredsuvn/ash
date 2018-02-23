@file:JvmName("Ash")

package org.volcraft.common

import kotlinx.coroutines.experimental.*
import org.volcraft.common.base.*
import java.math.BigDecimal
import java.math.BigInteger
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {
    println("Hello Ice!")

    println(Aaa::class.java.classLoader)

    val i = 1 + BigInteger("1")
    println(i)

    val d = 0.5 + BigDecimal("0.5")
    println(d)

    println(22 - BigDecimal("333"))

    println(TTT()["t2"])

//    File("").forEachBlock()

    var c = 0

    var ac = AtomicInteger()

    val begin = System.currentTimeMillis()
    for (i in 0 until 10000) {
        async(){
            c += 1
            ac.incrementAndGet()
            println("thread id: " + Thread.currentThread().id)
//            if (Thread.currentThread().id == 15L) {
//                s1()
//                delay(2000)
//                s2()
//            }
        }
//        Thread({
//            c += 1
//            ac.incrementAndGet()
//            println("thread id: " + Thread.currentThread().id)
//        }).start()
    }
    val end = System.currentTimeMillis()


    Thread.sleep(1000)

    println("thread id: ${Thread.currentThread().id}, c=$c, ac=$ac, cost: ${end - begin}.")

    runBlocking {

    }

    var closure = {i: Int -> println(i * i)}
    println(closure(100))

//    VLowerUnderscore.to(VUpperHyphen, "")
}

suspend fun s1() {
    print("1")
    print("2")
    print("3")
    println()
}

suspend fun s2() {
    print("x")
    print("y")
    print("z")
    println()
}

class Aaa