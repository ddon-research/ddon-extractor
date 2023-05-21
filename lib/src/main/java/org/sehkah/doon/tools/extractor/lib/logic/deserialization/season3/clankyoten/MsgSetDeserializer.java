package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.MsgData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.MsgGroup;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.clankyoten.MsgSet;

import java.util.ArrayList;
import java.util.List;

public class MsgSetDeserializer extends ClientResourceFileDeserializer<MsgSet> {
    public MsgSetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MsgData readMsgData(FileReader fileReader) {
        int UselessByte = fileReader.readUnsignedByte();
        return new MsgData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    private static MsgGroup readMsgGroup(FileReader fileReader) {
        int UselessByte = fileReader.readUnsignedByte();
        return new MsgGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readArray(MsgSetDeserializer::readMsgData)
        );
    }

    private static MsgSet readEntity(FileReader fileReader) {
        long NativeMsgGroupArrayNum = fileReader.readUnsignedInteger();
        long NativeMsgDataArrayNum = fileReader.readUnsignedInteger();

        List<MsgGroup> NativeMsgGroupArray = new ArrayList<>((int) NativeMsgGroupArrayNum);
        for (int i = 0; i < NativeMsgGroupArrayNum; i++) {
            NativeMsgGroupArray.add(readMsgGroup(fileReader));
        }

        return new MsgSet(
                NativeMsgGroupArrayNum,
                NativeMsgDataArrayNum,
                NativeMsgGroupArray
        );
    }

    @Override
    protected MsgSet parseClientResourceFile(FileReader fileReader) {
        return readEntity(fileReader);
    }
}