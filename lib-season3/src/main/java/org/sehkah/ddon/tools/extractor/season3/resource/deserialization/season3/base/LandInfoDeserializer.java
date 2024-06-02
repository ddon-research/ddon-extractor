package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.LandAreaInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.LandAreaInfoList;

public class LandInfoDeserializer extends ClientResourceFileDeserializer {
    public LandInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LandAreaInfo readLandAreaInfo(BufferReader bufferReader) {
        return new LandAreaInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte(),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected LandAreaInfoList parseClientResourceFile(BufferReader bufferReader) {
        return new LandAreaInfoList(bufferReader.readArray(LandInfoDeserializer::readLandAreaInfo));
    }
}
