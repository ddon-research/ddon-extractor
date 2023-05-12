package org.sehkah.doon.tools.extractor.lib.logic.deserialization.EM;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.EM.EmDmgTimerTbl;

import java.util.List;

public class EmDmgTimerTblDeserializer extends FileDeserializer<List<EmDmgTimerTbl>> {
    public EmDmgTimerTblDeserializer() {
        super(ClientResourceFile.rEmDmgTimerTbl);
    }

    private static EmDmgTimerTbl readEntity(FileReader fileReader) {
        return new EmDmgTimerTbl(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat()
        );
    }

    @Override
    protected List<EmDmgTimerTbl> readObject(FileReader fileReader) {
        return fileReader.readArray(EmDmgTimerTblDeserializer::readEntity);
    }
}
