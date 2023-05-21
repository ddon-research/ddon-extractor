package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AreaInfoStage;

import java.util.List;

public class AreaInfoStageDeserializer extends ClientResourceFileDeserializer<List<AreaInfoStage>> {
    public AreaInfoStageDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfoStage readEntity(FileReader fileReader) {
        return new AreaInfoStage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<AreaInfoStage> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AreaInfoStageDeserializer::readEntity);
    }
}
