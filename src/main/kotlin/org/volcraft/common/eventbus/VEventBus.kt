package org.volcraft.common.eventbus

import org.volcraft.common.parts.VSingleLinkedListNode

open class VEventBus {

    var baseTypes: Array<VSingleLinkedListNode<Any>> = arrayOf()

    fun register(event: Any): VEventBus {
//        var newArray = baseTypes
//        for (node in baseTypes) {
//            if (event::class.java == node.value!!::class.java) {
//                break
//            } else if (node.value!!::class.java.isAssignableFrom())
//        }
//        baseTypes = newArray
        return this
    }

    fun unregister(bean: Any): VEventBus {
        return this
    }

    fun post(event: Any): VEventBus {
        return this
    }
}