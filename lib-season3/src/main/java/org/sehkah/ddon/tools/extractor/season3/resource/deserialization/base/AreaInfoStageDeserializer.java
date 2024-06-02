package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.AreaInfoStage;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.AreaInfoStageList;

public class AreaInfoStageDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoStageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfoStage readAreaInfoStage(BufferReader bufferReader) {
        return new AreaInfoStage(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AreaInfoStageList parseClientResourceFile(BufferReader bufferReader) {
        return new AreaInfoStageList(bufferReader.readArray(AreaInfoStageDeserializer::readAreaInfoStage));
    }
}
