package com.spike.demo.netty.server.encoder;

import com.spike.demo.netty.server.model.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class ResponseEncoder extends MessageToByteEncoder<ResponseData> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ResponseData responseData, ByteBuf outBuf) throws Exception {

        outBuf.writeInt(responseData.getIntVal());
    }
}
