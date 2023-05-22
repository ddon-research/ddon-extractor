package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.AreaInfoStage;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.AreaInfoStageList;

public class AreaInfoStageDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoStageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfoStage readAreaInfoStage(FileReader fileReader) {
        return new AreaInfoStage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected AreaInfoStageList parseClientResourceFile(FileReader fileReader) {
        return new AreaInfoStageList(fileReader.readArray(AreaInfoStageDeserializer::readAreaInfoStage));
    }
}
