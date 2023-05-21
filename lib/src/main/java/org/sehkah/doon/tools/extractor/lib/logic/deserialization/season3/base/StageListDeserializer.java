package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.StageListInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.StageListInfoList;

public class StageListDeserializer extends ClientResourceFileDeserializer {
    public StageListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageListInfo readStageListInfo(FileReader fileReader) {
        return new StageListInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageListInfoList parseClientResourceFile(FileReader fileReader) {
        return new StageListInfoList(fileReader.readArray(StageListDeserializer::readStageListInfo));
    }
}
