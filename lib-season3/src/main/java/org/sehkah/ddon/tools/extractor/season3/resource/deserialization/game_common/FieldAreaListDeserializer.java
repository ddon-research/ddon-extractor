package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.FieldAreaInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.FieldAreaList;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.StageNo;

public class FieldAreaListDeserializer extends ClientResourceFileDeserializer {
    public FieldAreaListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static StageNo readStageNo(BufferReader bufferReader) {
        return new StageNo(
                bufferReader.readSignedInteger()
        );
    }

    private static FieldAreaInfo readFieldAreaInfo(BufferReader bufferReader) {
        return new FieldAreaInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readArray(FieldAreaListDeserializer::readStageNo),
                bufferReader.readArray(FieldAreaListDeserializer::readStageNo)
        );
    }

    @Override
    protected FieldAreaList parseClientResourceFile(BufferReader bufferReader) {
        return new FieldAreaList(bufferReader.readArray(FieldAreaListDeserializer::readFieldAreaInfo));
    }
}
