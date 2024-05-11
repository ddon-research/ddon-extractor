package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmWarpParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmWarpParamTable;

public class EmWarpParamTableDeserializer extends ClientResourceFileDeserializer {
    public EmWarpParamTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmWarpParam readEmWarpParam(BufferReader bufferReader) {
        return new EmWarpParam(
                bufferReader.readFixedLengthArray(3, BufferReader::readFloat),
                bufferReader.readFloat(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EmWarpParamTable parseClientResourceFile(BufferReader bufferReader) {
        return new EmWarpParamTable(bufferReader.readArray(EmWarpParamTableDeserializer::readEmWarpParam));
    }
}
