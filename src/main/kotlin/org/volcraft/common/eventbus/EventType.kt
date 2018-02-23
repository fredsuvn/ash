package org.volcraft.common.eventbus

import kotlin.reflect.KFunction

internal class EventType(val bean: Any, private val function: KFunction<*>) {
    fun run(event: Any) {
        function.call(event)
    }
}