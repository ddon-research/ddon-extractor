package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.FieldAreaInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.FieldAreaList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.StageNo;

public class FieldAreaListDeserializer extends ClientResourceFileDeserializer {
    public FieldAreaListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static StageNo readStageNo(FileReader fileReader) {
        return new StageNo(
                fileReader.readSignedInteger()
        );
    }

    private static FieldAreaInfo readFieldAreaInfo(FileReader fileReader) {
        return new FieldAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readArray(FieldAreaListDeserializer::readStageNo),
                fileReader.readArray(FieldAreaListDeserializer::readStageNo)
        );
    }

    @Override
    protected FieldAreaList parseClientResourceFile(FileReader fileReader) {
        return new FieldAreaList(fileReader.readArray(FieldAreaListDeserializer::readFieldAreaInfo));
    }
}
