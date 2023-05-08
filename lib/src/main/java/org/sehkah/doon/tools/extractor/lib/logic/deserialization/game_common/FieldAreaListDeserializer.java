package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.FieldAreaInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.StageNo;

public class FieldAreaListDeserializer extends FileDeserializer {
    public FieldAreaListDeserializer(FileReader fileReader) {
        super(ExtensionMap.rFieldAreaList, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(FieldAreaListDeserializer::readEntity);
    }
}
