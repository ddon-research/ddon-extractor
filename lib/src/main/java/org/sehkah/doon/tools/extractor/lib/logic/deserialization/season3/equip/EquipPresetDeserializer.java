package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.equip;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.equip.EquipPreset;

import java.util.List;

public class EquipPresetDeserializer extends ClientResourceFileDeserializer<List<EquipPreset>> {
    public EquipPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EquipPreset readEntity(FileReader fileReader) {
        return new EquipPreset(fileReader.readUnsignedInteger());
    }

    @Override
    protected List<EquipPreset> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(EquipPresetDeserializer::readEntity);
    }
}
