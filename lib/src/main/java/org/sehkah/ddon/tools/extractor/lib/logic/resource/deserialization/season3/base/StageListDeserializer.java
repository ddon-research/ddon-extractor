package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.StageListInfoList;

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
