package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AIPawnAutoWordNode;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.AIPawnAutoWordTbl;

import java.nio.file.Path;

public class AIPawnAutoWordTblDeserializer extends ClientResourceFileDeserializer<AIPawnAutoWordTbl> {


    private static AIPawnAutoWordNode readAIPawnAutoWordNode(BufferReader bufferReader) {
        return new AIPawnAutoWordNode(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(9, BufferReader::readUnsignedInteger),
                bufferReader.readFixedLengthArray(9, BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnAutoWordTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AIPawnAutoWordTbl(bufferReader.readArray(AIPawnAutoWordTblDeserializer::readAIPawnAutoWordNode));
    }
}
