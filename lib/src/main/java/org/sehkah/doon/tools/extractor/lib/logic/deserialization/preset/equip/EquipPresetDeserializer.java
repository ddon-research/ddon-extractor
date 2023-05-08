package org.sehkah.doon.tools.extractor.lib.logic.deserialization.preset.equip;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.preset.equip.EquipPreset;

public class EquipPresetDeserializer extends FileDeserializer {
    public EquipPresetDeserializer(FileReader fileReader) {
        super(ExtensionMap.rEquipPreset, fileReader);
    }

    private static EquipPreset readEntity(FileReader fileReader) {
        return new EquipPreset(
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(EquipPresetDeserializer::readEntity);
    }
}
