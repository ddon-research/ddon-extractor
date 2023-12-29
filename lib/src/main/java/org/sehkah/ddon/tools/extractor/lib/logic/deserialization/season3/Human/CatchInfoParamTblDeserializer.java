package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.CatchInfoParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.CatchInfoParamTbl;

// Works for both v18 (season 2) + v19 (season 3)
public class CatchInfoParamTblDeserializer extends ClientResourceFileDeserializer {
    public CatchInfoParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CatchInfoParam readCatchInfoParam(FileReader fileReader) {
        return new CatchInfoParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected CatchInfoParamTbl parseClientResourceFile(FileReader fileReader) {
        return new CatchInfoParamTbl(fileReader.readArray(CatchInfoParamTblDeserializer::readCatchInfoParam));
    }
}
