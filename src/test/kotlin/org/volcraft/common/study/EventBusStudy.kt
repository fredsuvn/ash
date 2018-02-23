package org.volcraft.common.study

import com.google.common.eventbus.EventBus
import com.google.common.eventbus.Subscribe
import kotlinx.coroutines.experimental.async
import java.util.*

open class Base {
    override fun toString(): String {
        return javaClass.toString()
    }
}

open class Ext1 : Base()
open class Ext2 : Ext1()

class Listener {

    @Subscribe
    fun base(base: Base) {
        println("on base")
        println(base.toString())
    }

    @Subscribe
    fun ext1(base: Ext1) {
        println("on ext1")
        println(base.toString())
    }

    @Subscribe
    fun ext2(base: Ext2) {
        println("on ext2")
        println(base.toString())
    }
}

class Listener2 {

    @Subscribe
    fun base(base: Base) {
        println("on base2")
        println(base.toString())
    }

    @Subscribe
    fun ext1(base: Ext1) {
        println("on ext12")
        println(base.toString())
    }

    @Subscribe
    fun ext2(base: Ext2) {
        println("on ext22")
        println(base.toString())
    }
}

fun main(args: Array<String>) {

    val eventBus = EventBus()
    eventBus.register(Listener())
    eventBus.register(Listener2())

    eventBus.post(Any())
    println("-------")
    eventBus.post(Base())
    println("-------")
    eventBus.post(Ext1())
    println("-------")
    eventBus.post(Ext2())


    val result = async {
        Thread.sleep(5000)
        println("async")
    }
    result.start()
}