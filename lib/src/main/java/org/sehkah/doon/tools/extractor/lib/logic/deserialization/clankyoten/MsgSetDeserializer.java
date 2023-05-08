package org.sehkah.doon.tools.extractor.lib.logic.deserialization.clankyoten;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.MsgData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.MsgGroup;
import org.sehkah.doon.tools.extractor.lib.logic.entity.clankyoten.MsgSet;

import java.util.ArrayList;
import java.util.List;

public class MsgSetDeserializer extends FileDeserializer<MsgSet> {
    public MsgSetDeserializer() {
        super(ClientResourceFile.rMsgSet);
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
    protected MsgSet readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
