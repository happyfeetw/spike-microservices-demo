package com.spike.demo.netty.client.encoder;

import com.spike.demo.netty.client.model.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class RequestDataEncoder extends MessageToByteEncoder<RequestData> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, RequestData requestData, ByteBuf outBuf) throws Exception {

        int intVal = requestData.getIntVal();
        String stringVal = requestData.getStringVal();
        outBuf.writeInt(intVal);
        outBuf.writeInt(stringVal.length());
        outBuf.writeCharSequence(stringVal, StandardCharsets.UTF_8);

    }
}
