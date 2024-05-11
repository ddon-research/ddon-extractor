package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.AbilityData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.AbilityDataList;

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
