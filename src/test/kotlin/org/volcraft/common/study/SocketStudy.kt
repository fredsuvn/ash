package org.volcraft.common.study

import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel

fun main(args: Array<String>) {
    val serverSocketChannel = ServerSocketChannel.open()
    serverSocketChannel.bind(InetSocketAddress(18080))
    serverSocketChannel.configureBlocking(false)

    val selector = Selector.open()
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT)

    while (true) {
        if (selector.select() != 0) {
            val keys = selector.selectedKeys().iterator()
            for (key in keys) {
                keys.remove()
                when {
                    key.isAcceptable -> {
                        val client = (key.channel() as ServerSocketChannel).accept()
                        client.configureBlocking(false)
                        client.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(10240))
                    }

                    key.isReadable -> {
                        val client = key.channel() as SocketChannel
                        val buf = key.attachment() as ByteBuffer
//                        buf.clear()
                        val read = client.read(buf)
                        if (read < 0){
                            client.close()
                        } else {
                            println(String(buf.array()))
                            key.interestOps(SelectionKey.OP_READ or SelectionKey.OP_WRITE)
                        }
                    }

                    key.isValid and key.isWritable -> {
                        val client = key.channel() as SocketChannel
                        val buf = key.attachment() as ByteBuffer
                        buf.clear()
                        buf.put("HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=utf-8\r\n\r\nHello Ice!".toByteArray())
                        buf.flip()
                        val leng = client.write(buf)
                            key.interestOps(SelectionKey.OP_READ)
                        buf.compact()
                    }
                }
            }
        }
    }
}