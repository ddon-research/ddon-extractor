package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EmWarpParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EmWarpParamTable;

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
