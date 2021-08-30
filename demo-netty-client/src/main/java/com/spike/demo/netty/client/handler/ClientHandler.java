package com.spike.demo.netty.client.handler;

import com.spike.demo.netty.client.model.RequestData;
import com.spike.demo.netty.client.model.ResponseData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        RequestData reqData = new RequestData();
        reqData.setIntVal(123);
        reqData.setStringVal("All work and no play makes Jack a dull boy.");
        ctx.writeAndFlush(reqData);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ResponseData resp = (ResponseData) msg;
        System.out.println(resp);
        ctx.close();
    }
}
