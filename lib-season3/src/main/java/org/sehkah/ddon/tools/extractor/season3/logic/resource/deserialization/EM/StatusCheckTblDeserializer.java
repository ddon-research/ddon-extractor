package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.StatusCheck;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.StatusCheckTbl;

import java.nio.file.Path;

public class StatusCheckTblDeserializer extends ClientResourceFileDeserializer<StatusCheckTbl> {


    private static StatusCheck readStatusCheck(BufferReader bufferReader) {
        return new StatusCheck(
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(3, BufferReader::readFloat),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected StatusCheckTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StatusCheckTbl(bufferReader.readArray(StatusCheckTblDeserializer::readStatusCheck));
    }
}
