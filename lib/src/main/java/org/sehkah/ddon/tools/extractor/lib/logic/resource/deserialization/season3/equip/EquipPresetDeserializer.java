package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.equip;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.equip.EquipPreset;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.equip.EquipPresetList;

public class EquipPresetDeserializer extends ClientResourceFileDeserializer {
    public EquipPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EquipPreset readEquipPreset(FileReader fileReader) {
        return new EquipPreset(fileReader.readUnsignedInteger());
    }

    @Override
    protected EquipPresetList parseClientResourceFile(FileReader fileReader) {
        return new EquipPresetList(fileReader.readArray(EquipPresetDeserializer::readEquipPreset));
    }
}
