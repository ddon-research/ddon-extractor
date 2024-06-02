package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.EventParam;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.EventParamList;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.OmList;

public class EventParamDeserializer extends ClientResourceFileDeserializer {
    public EventParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OmList readOmList(BufferReader bufferReader) {
        return new OmList(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort()
        );
    }

    private static EventParam readEventParam(BufferReader bufferReader) {
        return new EventParam(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readFloat(),
                bufferReader.readArray(EventParamDeserializer::readOmList)
        );
    }

    @Override
    protected EventParamList parseClientResourceFile(BufferReader bufferReader) {
        return new EventParamList(bufferReader.readArray(EventParamDeserializer::readEventParam));
    }
}
