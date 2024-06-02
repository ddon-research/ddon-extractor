package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base.AreaInfoStage;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.base.AreaInfoStageList;

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
