package org.volcraft.common.block

import java.nio.channels.FileChannel

interface VBlock {

    var step: Int

    fun get(): Byte

    fun put(b: Byte): FileChannel

    operator fun get(position: Long): Byte

    operator fun get(position: VPointer): Byte
}