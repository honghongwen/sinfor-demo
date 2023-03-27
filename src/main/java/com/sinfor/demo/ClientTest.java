package com.sinfor.demo;

import cn.hutool.json.JSONUtil;
import com.sinfor.demo.param.LoginParam;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author fengwen
 * @date 2022/4/26
 * @description TODO
 **/
public class ClientTest {

    private static final EventLoopGroup group = new NioEventLoopGroup();

    public static void main(String[] args) throws Exception {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    // 自定义处理程序
                    socketChannel.pipeline().addLast(new ClientHandler());
                }
            });
            // 绑定端口并同步等待
            ChannelFuture channelFuture = bootstrap.connect("localhost", 9898).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    static class ClientHandler extends ChannelInboundHandlerAdapter {

        /**
         * 连接到服务器时触发
         */
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            extracted(ctx);
        }

        private void extracted(ChannelHandlerContext ctx) {
            Integer min = Integer.MIN_VALUE;
            ByteBuf buffer = Unpooled.buffer();
            buffer.writeInt(min);
            int seq = 10000;
            buffer.writeInt(seq);

            String version = "1.0";
            byte[] versionBytes = version.getBytes(StandardCharsets.UTF_8);
            buffer.writeBytes(versionBytes);

            int module = 99000001;
            buffer.writeInt(module);
            int cmd = 1001;
            buffer.writeShort(cmd);
            LoginParam param = new LoginParam();
            param.setUserId("7570310001");
            param.setPassword("111");
            param.setMachmac("tsfsffff");
            param.setMachname("1234");
            String data = JSONUtil.toJsonStr(param);
            byte[] reqBytes = data.getBytes(StandardCharsets.UTF_8);

//        byte[] reqBytes = "120".getBytes();
//            byte[] sign = Util.getSign((short) seq, module, (short) cmd, reqBytes);
//            buffer.writeBytes(sign);
            buffer.writeBoolean(false);
            buffer.writeInt(reqBytes.length);
            buffer.writeBytes(reqBytes);
            ctx.writeAndFlush(buffer);
        }

        /**
         * 消息到来时触发
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
            System.out.println("Current Time: " + buf.toString(CharsetUtil.UTF_8));
        }

        /**
         * 发生异常时触发
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }


    }
}

