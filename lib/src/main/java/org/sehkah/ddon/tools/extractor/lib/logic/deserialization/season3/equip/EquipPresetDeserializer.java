package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.equip;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.equip.EquipPreset;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.equip.EquipPresetList;

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
