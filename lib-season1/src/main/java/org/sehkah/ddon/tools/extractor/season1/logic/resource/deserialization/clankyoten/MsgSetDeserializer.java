package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.clankyoten;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.clankyoten.MsgData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.clankyoten.MsgGroup;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.clankyoten.MsgSet;

import java.util.ArrayList;
import java.util.List;

public class MsgSetDeserializer extends ClientResourceFileDeserializer<MsgSet> {


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
    protected MsgSet parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
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
