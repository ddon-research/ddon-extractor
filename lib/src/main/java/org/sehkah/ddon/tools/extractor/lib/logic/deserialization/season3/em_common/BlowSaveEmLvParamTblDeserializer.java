package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.em_common.BlowSaveEmLvParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.em_common.BlowSaveEmLvParamTbl;

public class BlowSaveEmLvParamTblDeserializer extends ClientResourceFileDeserializer {
    public BlowSaveEmLvParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static BlowSaveEmLvParam readBlowSaveEmLvParam(FileReader fileReader) {
        return new BlowSaveEmLvParam(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    @Override
    protected BlowSaveEmLvParamTbl parseClientResourceFile(FileReader fileReader) {
        return new BlowSaveEmLvParamTbl(fileReader.readArray(BlowSaveEmLvParamTblDeserializer::readBlowSaveEmLvParam));
    }
}
