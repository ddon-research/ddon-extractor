package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.Human.CaughtInfoParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.Human.CaughtInfoParamTbl;

// Works for v15 (season 2) & v16 (season 3)
public class CaughtInfoParamTblDeserializer extends ClientResourceFileDeserializer {
    public CaughtInfoParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CaughtInfoParam readCaughtInfoParam(BufferReader bufferReader) {
        return new CaughtInfoParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readVector3f()
        );
    }

    @Override
    protected CaughtInfoParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CaughtInfoParamTbl(bufferReader.readArray(CaughtInfoParamTblDeserializer::readCaughtInfoParam));
    }
}
