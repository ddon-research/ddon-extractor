package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ShotReqInfo2;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ShotReqInfo2Param;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.ShotReqInfo2Tbl;

public class ShotReqInfo2TblDeserializer extends ClientResourceFileDeserializer {
    public ShotReqInfo2TblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected ShotReqInfo2Tbl parseClientResourceFile(BufferReader bufferReader) {
        return new ShotReqInfo2Tbl(bufferReader.readArray(ShotReqInfo2TblDeserializer::readShotReqInfo2));
    }
}
