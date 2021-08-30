package com.spike.demo.netty.server.handler;

import com.spike.demo.netty.server.model.RequestData;
import com.spike.demo.netty.server.model.ResponseData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class ProcessingHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RequestData reqData = (RequestData) msg;
        ResponseData respData = new ResponseData();
        respData.setIntVal(reqData.getIntVal() * 2);
        ChannelFuture future = ctx.writeAndFlush(respData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println("reqData = " + reqData);
    }
}
