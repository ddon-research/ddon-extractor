package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmDmgTimerTbl;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmDmgTimerTblList;

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
