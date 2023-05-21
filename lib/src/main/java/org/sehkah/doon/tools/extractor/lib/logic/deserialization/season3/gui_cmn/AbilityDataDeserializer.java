package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.AbilityData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.AbilityDataList;

public class AbilityDataDeserializer extends ClientResourceFileDeserializer {
    public AbilityDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AbilityData readAbilityData(FileReader fileReader) {
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
    protected AbilityDataList parseClientResourceFile(FileReader fileReader) {
        return new AbilityDataList(fileReader.readArray(AbilityDataDeserializer::readAbilityData));
    }
}
