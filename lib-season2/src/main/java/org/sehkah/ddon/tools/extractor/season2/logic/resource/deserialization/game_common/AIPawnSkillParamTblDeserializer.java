package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AIPawnSkillParamNode;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AIPawnSkillParamTbl;

import java.nio.file.Path;

public class AIPawnSkillParamTblDeserializer extends ClientResourceFileDeserializer<AIPawnSkillParamTbl> {


    private static AIPawnSkillParamNode readAIPawnSkillParamNode(BufferReader bufferReader) {
        return new AIPawnSkillParamNode(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFixedLengthArray(16, BufferReader::readUnsignedInteger),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnSkillParamTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AIPawnSkillParamTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnSkillParamTblDeserializer::readAIPawnSkillParamNode));
    }
}
