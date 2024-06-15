package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfo2;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfo2Param;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfo2Tbl;

import java.nio.file.Path;

public class ShotReqInfo2TblDeserializer extends ClientResourceFileDeserializer<ShotReqInfo2Tbl> {


    private static ShotReqInfo2Param readShotReqInfo2Param(BufferReader bufferReader) {
        return new ShotReqInfo2Param(
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    private static ShotReqInfo2 readShotReqInfo2(BufferReader bufferReader) {
        return new ShotReqInfo2(bufferReader.readFixedLengthArray(3, ShotReqInfo2TblDeserializer::readShotReqInfo2Param));
    }

    @Override
    protected ShotReqInfo2Tbl parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new ShotReqInfo2Tbl(bufferReader.readArray(ShotReqInfo2TblDeserializer::readShotReqInfo2));
    }
}
