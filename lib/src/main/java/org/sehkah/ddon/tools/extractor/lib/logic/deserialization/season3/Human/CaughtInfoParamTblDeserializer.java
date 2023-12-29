package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.Human;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.CaughtInfoParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.Human.CaughtInfoParamTbl;

// Works for v15 (season 2) & v16 (season 3)
public class CaughtInfoParamTblDeserializer extends ClientResourceFileDeserializer {
    public CaughtInfoParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CaughtInfoParam readCaughtInfoParam(FileReader fileReader) {
        return new CaughtInfoParam(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readVector3f(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected CaughtInfoParamTbl parseClientResourceFile(FileReader fileReader) {
        return new CaughtInfoParamTbl(fileReader.readArray(CaughtInfoParamTblDeserializer::readCaughtInfoParam));
    }
}
