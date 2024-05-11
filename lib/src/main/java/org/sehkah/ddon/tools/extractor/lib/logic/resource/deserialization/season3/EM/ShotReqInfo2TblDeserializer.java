package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.ShotReqInfo2;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.ShotReqInfo2Param;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.ShotReqInfo2Tbl;

public class ShotReqInfo2TblDeserializer extends ClientResourceFileDeserializer {
    public ShotReqInfo2TblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShotReqInfo2Param readShotReqInfo2Param(FileReader fileReader) {
        return new ShotReqInfo2Param(
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    private static ShotReqInfo2 readShotReqInfo2(FileReader fileReader) {
        return new ShotReqInfo2(fileReader.readFixedLengthArray(3, ShotReqInfo2TblDeserializer::readShotReqInfo2Param));
    }

    @Override
    protected ShotReqInfo2Tbl parseClientResourceFile(FileReader fileReader) {
        return new ShotReqInfo2Tbl(fileReader.readArray(ShotReqInfo2TblDeserializer::readShotReqInfo2));
    }
}
