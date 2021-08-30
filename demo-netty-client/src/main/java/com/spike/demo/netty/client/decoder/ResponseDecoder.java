package com.spike.demo.netty.client.decoder;

import com.spike.demo.netty.client.model.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * date: 2021/8/30
 * author: Spike
 * description:
 */
public class ResponseDecoder extends ReplayingDecoder<ResponseData> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf inBuf, List<Object> result) throws Exception {
        ResponseData respData = new ResponseData();
        int in = inBuf.readInt();
        respData.setIntVal(in);
        result.add(respData);
    }
}
