package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.LandAreaInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.base.LandAreaInfoList;

public class LandInfoDeserializer extends ClientResourceFileDeserializer {
    public LandInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LandAreaInfo readLandAreaInfo(BufferReader bufferReader) {
        return new LandAreaInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected LandAreaInfoList parseClientResourceFile(BufferReader bufferReader) {
        return new LandAreaInfoList(bufferReader.readArray(LandInfoDeserializer::readLandAreaInfo));
    }
}
