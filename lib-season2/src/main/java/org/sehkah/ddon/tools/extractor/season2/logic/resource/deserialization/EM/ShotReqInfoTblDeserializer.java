package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfoTbl;

public class ShotReqInfoTblDeserializer extends ClientResourceFileDeserializer<ShotReqInfoTbl> {


    private static ShotReqInfo readShotReqInfo(BufferReader bufferReader) {
        return new ShotReqInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected ShotReqInfoTbl parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ShotReqInfoTbl(bufferReader.readArray(ShotReqInfoTblDeserializer::readShotReqInfo));
    }
}
