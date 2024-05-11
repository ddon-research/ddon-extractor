package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmWarpParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EmWarpParamTable;

public class EmWarpParamTableDeserializer extends ClientResourceFileDeserializer {
    public EmWarpParamTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmWarpParam readEmWarpParam(FileReader fileReader) {
        return new EmWarpParam(
                fileReader.readFixedLengthArray(3, FileReader::readFloat),
                fileReader.readFloat(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected EmWarpParamTable parseClientResourceFile(FileReader fileReader) {
        return new EmWarpParamTable(fileReader.readArray(EmWarpParamTableDeserializer::readEmWarpParam));
    }
}
