package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.EventParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.EventParamList;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.OmList;

public class EventParamDeserializer extends ClientResourceFileDeserializer {
    public EventParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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

    private static EventParam readEventParam(FileReader fileReader) {
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
    protected EventParamList parseClientResourceFile(FileReader fileReader) {
        return new EventParamList(fileReader.readArray(EventParamDeserializer::readEventParam));
    }
}
