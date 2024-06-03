package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmDmgTimerTbl;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmDmgTimerTblList;

public class EmDmgTimerTblDeserializer extends ClientResourceFileDeserializer {
    public EmDmgTimerTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmDmgTimerTbl readEmDmgTimerTbl(BufferReader bufferReader) {
        return new EmDmgTimerTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected EmDmgTimerTblList parseClientResourceFile(BufferReader bufferReader) {
        return new EmDmgTimerTblList(bufferReader.readArray(EmDmgTimerTblDeserializer::readEmDmgTimerTbl));
    }
}
