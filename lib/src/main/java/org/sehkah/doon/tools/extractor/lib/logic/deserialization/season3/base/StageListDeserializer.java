package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.StageListInfo;

import java.util.List;

public class StageListDeserializer extends ClientResourceFileDeserializer<List<StageListInfo>> {
    public StageListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<StageListInfo> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(StageListDeserializer::readEntity);
    }
}
