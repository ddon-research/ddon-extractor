package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.AbilityData;

public class AbilityDataDeserializer extends FileDeserializer {
    public AbilityDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAbilityData, fileReader);
    }

    private static AbilityData readEntity(FileReader fileReader) {
        return new AbilityData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AbilityDataDeserializer::readEntity);
    }
}
