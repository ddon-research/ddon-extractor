package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfoStage;

import java.util.List;

public class AreaInfoStageDeserializer extends FileDeserializer<List<AreaInfoStage>> {
    public AreaInfoStageDeserializer() {
        super(ClientResourceFile.rAreaInfoStage);
    }

    private static AreaInfoStage readEntity(FileReader fileReader) {
        return new AreaInfoStage(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<AreaInfoStage> readObject(FileReader fileReader) {
        return fileReader.readArray(AreaInfoStageDeserializer::readEntity);
    }
}
