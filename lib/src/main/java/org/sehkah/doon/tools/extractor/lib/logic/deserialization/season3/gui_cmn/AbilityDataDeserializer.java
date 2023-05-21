package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.AbilityData;

import java.util.List;

public class AbilityDataDeserializer extends ClientResourceFileDeserializer<List<AbilityData>> {
    public AbilityDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<AbilityData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AbilityDataDeserializer::readEntity);
    }
}
