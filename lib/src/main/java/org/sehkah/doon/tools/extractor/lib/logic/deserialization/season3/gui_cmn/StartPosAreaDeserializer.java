package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.StartPosArea;

import java.util.List;

public class StartPosAreaDeserializer extends ClientResourceFileDeserializer<List<StartPosArea>> {
    public StartPosAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StartPosArea readEntity(FileReader fileReader) {
        return new StartPosArea(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected List<StartPosArea> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(StartPosAreaDeserializer::readEntity);
    }
}
