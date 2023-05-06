package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.StartPosArea;

public class StartPosAreaDeserializer extends FileDeserializer {
    public StartPosAreaDeserializer(FileReader fileReader) {
        super(ExtensionMap.rStartPosArea, fileReader);
    }

    private static StartPosArea readEntity(FileReader fileReader) {
        return new StartPosArea(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(StartPosAreaDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
