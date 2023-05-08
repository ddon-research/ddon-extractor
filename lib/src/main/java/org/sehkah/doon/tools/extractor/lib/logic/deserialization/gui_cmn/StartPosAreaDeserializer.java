package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.StartPosArea;

import java.util.List;

public class StartPosAreaDeserializer extends FileDeserializer<List<StartPosArea>> {
    public StartPosAreaDeserializer() {
        super(ClientResourceFile.rStartPosArea);
    }

    private static StartPosArea readEntity(FileReader fileReader) {
        return new StartPosArea(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected List<StartPosArea> readObject(FileReader fileReader) {
        return fileReader.readArray(StartPosAreaDeserializer::readEntity);
    }
}
