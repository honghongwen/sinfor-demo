package com.sinfor.demo.service;

import com.sinfor.stater.net.domain.Request;
import com.sinfor.stater.net.domain.Response;
import com.sinfor.stater.net.exports.ChannelContextHolder;
import com.sinfor.stater.net.exports.RequestHolder;
import io.netty.channel.ChannelHandlerContext;

import java.nio.charset.StandardCharsets;

public interface WriteAndFlushService {

    default void writeOk(Object data) {
        ChannelHandlerContext channelCtx = ChannelContextHolder.getChannelCtx();
        Request request = RequestHolder.getReq();
        channelCtx.writeAndFlush(Response.getInstance(request).ok(data).encrypt());
    }

    default void writeOk(Short sequence, Object data) {
        ChannelHandlerContext channelCtx = ChannelContextHolder.getChannelCtx();
        Request request = RequestHolder.getReq();
        Response response = Response.getInstance(request).ok(data).sequence(sequence).jMeter(null).encrypt();
        if (sequence == Short.MAX_VALUE) {
            response.setJMeter("\n".getBytes(StandardCharsets.UTF_8));
        }
        channelCtx.writeAndFlush(response);
    }

}
