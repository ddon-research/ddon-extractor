package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.CaughtInfoParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.Human.CaughtInfoParamTbl;

// Works for v15 (season 2) & v16 (season 3)
public class CaughtInfoParamTblDeserializer extends ClientResourceFileDeserializer<CaughtInfoParamTbl> {


    private static CaughtInfoParam readCaughtInfoParam(BufferReader bufferReader) {
        return new CaughtInfoParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected CaughtInfoParamTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CaughtInfoParamTbl(bufferReader.readArray(CaughtInfoParamTblDeserializer::readCaughtInfoParam));
    }
}
