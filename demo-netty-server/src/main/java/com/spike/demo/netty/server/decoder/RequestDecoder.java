package com.spike.demo.netty.server.decoder;

import com.spike.demo.netty.server.model.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class RequestDecoder extends ReplayingDecoder<RequestData> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf inBuf, List<Object> outList) throws Exception {
        RequestData reqData = new RequestData();
        reqData.setIntVal(inBuf.readInt());
        int strLen = inBuf.readInt();
        reqData.setStringVal(inBuf.readCharSequence(strLen, StandardCharsets.UTF_8).toString());
        outList.add(reqData);

    }
}
