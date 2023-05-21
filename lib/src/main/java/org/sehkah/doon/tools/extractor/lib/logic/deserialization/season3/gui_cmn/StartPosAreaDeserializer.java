package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.StartPosArea;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.StartPosAreaList;

public class StartPosAreaDeserializer extends ClientResourceFileDeserializer {
    public StartPosAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StartPosArea readStartPosArea(FileReader fileReader) {
        return new StartPosArea(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected StartPosAreaList parseClientResourceFile(FileReader fileReader) {
        return new StartPosAreaList(fileReader.readArray(StartPosAreaDeserializer::readStartPosArea));
    }
}
