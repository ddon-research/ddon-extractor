package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.collision_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.collision_common.PushRate;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.collision_common.PushRateList;

public class PushRateListDeserializer extends ClientResourceFileDeserializer {
    public PushRateListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PushRate readPushRate(FileReader fileReader) {
        return new PushRate(
                fileReader.readFixedLengthArray(6, FileReader::readFloat)
        );
    }

    @Override
    protected PushRateList parseClientResourceFile(FileReader fileReader) {
        return new PushRateList(fileReader.readArray(PushRateListDeserializer::readPushRate));
    }
}
