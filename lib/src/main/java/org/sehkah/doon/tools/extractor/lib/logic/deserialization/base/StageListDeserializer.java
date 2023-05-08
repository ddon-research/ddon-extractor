package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StageListInfo;

import java.util.List;

public class StageListDeserializer extends FileDeserializer<List<StageListInfo>> {
    public StageListDeserializer() {
        super(ClientResourceFile.rStageList);
    }

    private static StageListInfo readEntity(FileReader fileReader) {
        return new StageListInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<StageListInfo> readObject(FileReader fileReader) {
        return fileReader.readArray(StageListDeserializer::readEntity);
    }
}
