package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.EventParam;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.OmList;

import java.util.List;

public class EventParamDeserializer extends FileDeserializer<List<EventParam>> {
    public EventParamDeserializer() {
        super(ClientResourceFile.rEventParam);
    }

    private static OmList readOmList(FileReader fileReader) {
        return new OmList(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort()
        );
    }

    private static EventParam readEntity(FileReader fileReader) {
        return new EventParam(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readFloat(),
                fileReader.readArray(EventParamDeserializer::readOmList)
        );
    }

    @Override
    protected List<EventParam> readObject(FileReader fileReader) {
        return fileReader.readArray(EventParamDeserializer::readEntity);
    }
}
