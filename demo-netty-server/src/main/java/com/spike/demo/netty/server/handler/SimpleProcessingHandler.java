package com.spike.demo.netty.server.handler;

import com.spike.demo.netty.server.model.RequestData;
import com.spike.demo.netty.server.model.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf tmp;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Handler added");
        tmp = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Handler removed");
        tmp.release();
        tmp = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        tmp.writeBytes(buf);
        buf.release();

        if (buf.readableBytes() > 4) {
            RequestData req = new RequestData();
            req.setIntVal(tmp.readInt());
            ResponseData resp = new ResponseData();
            resp.setIntVal(req.getIntVal() * 2);
            ChannelFuture cf = ctx.writeAndFlush(resp);
            cf.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
