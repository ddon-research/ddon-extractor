package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.MsgData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.MsgGroup;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.clankyoten.MsgSet;

import java.util.ArrayList;
import java.util.List;

public class MsgSetDeserializer extends ClientResourceFileDeserializer {
    public MsgSetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MsgData readMsgData(BufferReader bufferReader) {
        bufferReader.readUnsignedByte();
        return new MsgData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    private static MsgGroup readMsgGroup(BufferReader bufferReader) {
        bufferReader.readUnsignedByte();
        return new MsgGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readArray(MsgSetDeserializer::readMsgData)
        );
    }

    @Override
    protected MsgSet parseClientResourceFile(BufferReader bufferReader) {
        long NativeMsgGroupArrayNum = bufferReader.readUnsignedInteger();
        long NativeMsgDataArrayNum = bufferReader.readUnsignedInteger();

        List<MsgGroup> NativeMsgGroupArray = new ArrayList<>((int) NativeMsgGroupArrayNum);
        for (int i = 0; i < NativeMsgGroupArrayNum; i++) {
            NativeMsgGroupArray.add(readMsgGroup(bufferReader));
        }

        return new MsgSet(
                NativeMsgGroupArrayNum,
                NativeMsgDataArrayNum,
                NativeMsgGroupArray
        );
    }
}
