package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.ShotReqInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.ShotReqInfoTbl;

public class ShotReqInfoTblDeserializer extends ClientResourceFileDeserializer {
    public ShotReqInfoTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static ShotReqInfo readShotReqInfo(FileReader fileReader) {
        return new ShotReqInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected ShotReqInfoTbl parseClientResourceFile(FileReader fileReader) {
        return new ShotReqInfoTbl(fileReader.readArray(ShotReqInfoTblDeserializer::readShotReqInfo));
    }
}
