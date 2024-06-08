package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.CatchInfoParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.CatchInfoParamTbl;

import java.nio.file.Path;

// Works for both v18 (season 2) + v19 (season 3)
public class CatchInfoParamTblDeserializer extends ClientResourceFileDeserializer<CatchInfoParamTbl> {


    private static CatchInfoParam readCatchInfoParam(BufferReader bufferReader) {
        return new CatchInfoParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected CatchInfoParamTbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CatchInfoParamTbl(bufferReader.readArray(CatchInfoParamTblDeserializer::readCatchInfoParam));
    }
}
