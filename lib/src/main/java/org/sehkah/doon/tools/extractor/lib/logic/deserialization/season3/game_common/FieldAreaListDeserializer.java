package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.FieldAreaInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.StageNo;

import java.util.List;

public class FieldAreaListDeserializer extends ClientResourceFileDeserializer<List<FieldAreaInfo>> {
    public FieldAreaListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static FieldAreaInfo readEntity(FileReader fileReader) {
        return new FieldAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readArray(FieldAreaListDeserializer::readStageNo),
                fileReader.readArray(FieldAreaListDeserializer::readStageNo)
        );
    }

    private static StageNo readStageNo(FileReader fileReader) {
        return new StageNo(
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected List<FieldAreaInfo> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(FieldAreaListDeserializer::readEntity);
    }
}
