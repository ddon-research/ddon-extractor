package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.collision_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.collision_common.PushRate;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.collision_common.PushRateList;

public class PushRateListDeserializer extends ClientResourceFileDeserializer {
    public PushRateListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PushRate readPushRate(BufferReader bufferReader) {
        return new PushRate(
                bufferReader.readFixedLengthArray(6, BufferReader::readFloat)
        );
    }

    @Override
    protected PushRateList parseClientResourceFile(BufferReader bufferReader) {
        return new PushRateList(bufferReader.readArray(PushRateListDeserializer::readPushRate));
    }
}
