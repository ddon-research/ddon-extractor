package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.em_common.BlowSaveEmLvParam;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.em_common.BlowSaveEmLvParamTbl;

public class BlowSaveEmLvParamTblDeserializer extends ClientResourceFileDeserializer {
    public BlowSaveEmLvParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static BlowSaveEmLvParam readBlowSaveEmLvParam(BufferReader bufferReader) {
        return new BlowSaveEmLvParam(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected BlowSaveEmLvParamTbl parseClientResourceFile(BufferReader bufferReader) {
        return new BlowSaveEmLvParamTbl(bufferReader.readArray(BlowSaveEmLvParamTblDeserializer::readBlowSaveEmLvParam));
    }
}
