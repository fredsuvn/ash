package org.volcraft.common.study

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.Unpooled
import io.netty.channel.*
import io.netty.channel.oio.OioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.oio.OioServerSocketChannel
import java.net.InetSocketAddress
import java.nio.charset.Charset
import io.netty.handler.codec.string.StringDecoder



fun main(args: Array<String>) {
    val buf = Unpooled.unreleasableBuffer(
            Unpooled.copiedBuffer("HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "\n" +
                    "Hello Ice!", Charset.forName("UTF-8")))
    val group = OioEventLoopGroup()
    val serverBootstrap = ServerBootstrap()

    serverBootstrap.group(group)
            .channel(OioServerSocketChannel::class.java)
            .localAddress(InetSocketAddress(18080))
            .childHandler(object : ChannelInitializer<SocketChannel>() {
                override fun initChannel(ch: SocketChannel?) {
                    ch?.pipeline()
                            ?.addLast("zzz", object : ChannelInboundHandlerAdapter() {
                                override fun channelActive(ctx: ChannelHandlerContext) {
                                    ctx.writeAndFlush(buf.duplicate())//.addListener(ChannelFutureListener.CLOSE)
                                    super.channelActive(ctx)
                                }
                            })
                            ?.addLast("decoder", StringDecoder())
                            ?.addLast("send", object: SimpleChannelInboundHandler<String>(){
                                override fun channelRead0(ctx: ChannelHandlerContext?, msg: String?) {
                                    println(msg)
                                    ctx?.close()
                                }
                            })
                }
            })
    val channelFuture = serverBootstrap.bind().sync()
    channelFuture.channel().closeFuture().sync()
}