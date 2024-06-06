package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmDmgTimerTbl;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EmDmgTimerTblList;

public class EmDmgTimerTblDeserializer extends ClientResourceFileDeserializer {


    private static EmDmgTimerTbl readEmDmgTimerTbl(BufferReader bufferReader) {
        return new EmDmgTimerTbl(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected EmDmgTimerTblList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EmDmgTimerTblList(bufferReader.readArray(EmDmgTimerTblDeserializer::readEmDmgTimerTbl));
    }
}
