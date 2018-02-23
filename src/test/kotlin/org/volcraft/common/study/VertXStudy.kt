package org.volcraft.common.study

import io.vertx.core.*

fun main(args: Array<String>) {
    Vertx.vertx().createHttpServer().requestHandler { request ->
        println(request.bodyHandler { buffer -> println(String(buffer.bytes)) })
        Thread.sleep(10000)
        request.response().isChunked = true
        request.response().end("Hello Ice!")
    }.listen(18080)

    Vertx.vertx().createHttpServer().requestHandler { request ->
        println(request.bodyHandler { buffer -> println(String(buffer.bytes)) })
        Thread.sleep(10000)
        request.response().isChunked = true
        request.response().end("Hello Ice!")
    }.listen(18080)
//    Server().start()
//
//    Thread.sleep(10000000)
}

class Server : AbstractVerticle() {
    override fun start(stopFuture: Future<Void>?) {
        vertx.createHttpServer().requestHandler { request ->
            println(request.bodyHandler { buffer -> println(String(buffer.bytes)) })
            val resp = request.response()
            resp.isChunked = true
            resp.headers().add("Content-Length", "1024")
            for (i in 1..10086){
                println(i)
            }

            resp.write("Hello Ice!")
        }.listen(18080)
    }
}