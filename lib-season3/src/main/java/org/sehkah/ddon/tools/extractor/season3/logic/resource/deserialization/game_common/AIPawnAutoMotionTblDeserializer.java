package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.AIPawnAutoMotionNode;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.AIPawnAutoMotionTbl;

public class AIPawnAutoMotionTblDeserializer extends ClientResourceFileDeserializer<AIPawnAutoMotionTbl> {


    private static AIPawnAutoMotionNode readAIPawnAutoMotionNode(BufferReader bufferReader) {
        return new AIPawnAutoMotionNode(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readArray(BufferReader::readUnsignedInteger),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AIPawnAutoMotionTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AIPawnAutoMotionTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnAutoMotionTblDeserializer::readAIPawnAutoMotionNode));
    }
}
