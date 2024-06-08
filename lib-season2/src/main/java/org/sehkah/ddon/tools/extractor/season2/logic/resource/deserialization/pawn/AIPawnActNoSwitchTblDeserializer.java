package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.pawn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.pawn.AIPawnActNoSwitch;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.pawn.AIPawnActNoSwitchTbl;

import java.nio.file.Path;

public class AIPawnActNoSwitchTblDeserializer extends ClientResourceFileDeserializer<AIPawnActNoSwitchTbl> {


    private static AIPawnActNoSwitch readAIPawnActNoSwitch(BufferReader bufferReader) {
        return new AIPawnActNoSwitch(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected AIPawnActNoSwitchTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AIPawnActNoSwitchTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AIPawnActNoSwitchTblDeserializer::readAIPawnActNoSwitch));
    }
}
