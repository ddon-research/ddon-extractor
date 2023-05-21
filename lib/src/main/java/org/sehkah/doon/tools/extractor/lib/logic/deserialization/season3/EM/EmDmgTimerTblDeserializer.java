package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.EmDmgTimerTbl;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.EmDmgTimerTblList;

public class EmDmgTimerTblDeserializer extends ClientResourceFileDeserializer {
    public EmDmgTimerTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmDmgTimerTbl readEmDmgTimerTbl(FileReader fileReader) {
        return new EmDmgTimerTbl(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    @Override
    protected EmDmgTimerTblList parseClientResourceFile(FileReader fileReader) {
        return new EmDmgTimerTblList(fileReader.readArray(EmDmgTimerTblDeserializer::readEmDmgTimerTbl));
    }
}
