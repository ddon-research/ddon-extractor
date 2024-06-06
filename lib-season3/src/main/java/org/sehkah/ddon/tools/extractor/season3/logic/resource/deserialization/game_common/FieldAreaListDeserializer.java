package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.FieldAreaInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.FieldAreaList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.StageNo;

public class FieldAreaListDeserializer extends ClientResourceFileDeserializer {


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
    protected FieldAreaList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FieldAreaList(bufferReader.readArray(FieldAreaListDeserializer::readFieldAreaInfo));
    }
}
