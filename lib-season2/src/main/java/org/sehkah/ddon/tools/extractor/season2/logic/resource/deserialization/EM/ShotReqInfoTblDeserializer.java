package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.ShotReqInfoTbl;

public class ShotReqInfoTblDeserializer extends ClientResourceFileDeserializer {
    public ShotReqInfoTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected ShotReqInfoTbl parseClientResourceFile(BufferReader bufferReader) {
        return new ShotReqInfoTbl(bufferReader.readArray(ShotReqInfoTblDeserializer::readShotReqInfo));
    }
}
