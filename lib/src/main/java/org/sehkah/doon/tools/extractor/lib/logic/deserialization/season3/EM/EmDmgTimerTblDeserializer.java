package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.EM.EmDmgTimerTbl;

import java.util.List;

public class EmDmgTimerTblDeserializer extends ClientResourceFileDeserializer<List<EmDmgTimerTbl>> {
    public EmDmgTimerTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmDmgTimerTbl readEntity(FileReader fileReader) {
        return new EmDmgTimerTbl(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    @Override
    protected List<EmDmgTimerTbl> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(EmDmgTimerTblDeserializer::readEntity);
    }
}
