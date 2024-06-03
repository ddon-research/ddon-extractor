package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.CatchInfoParam;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.Human.CatchInfoParamTbl;

// Works for both v18 (season 2) + v19 (season 3)
public class CatchInfoParamTblDeserializer extends ClientResourceFileDeserializer {
    public CatchInfoParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected CatchInfoParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new CatchInfoParamTbl(bufferReader.readArray(CatchInfoParamTblDeserializer::readCatchInfoParam));
    }
}
