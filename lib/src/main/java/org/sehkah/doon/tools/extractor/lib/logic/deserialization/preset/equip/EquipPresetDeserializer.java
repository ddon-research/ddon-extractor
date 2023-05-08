package org.sehkah.doon.tools.extractor.lib.logic.deserialization.preset.equip;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.preset.equip.EquipPreset;

import java.util.List;

public class EquipPresetDeserializer extends FileDeserializer<List<EquipPreset>> {
    public EquipPresetDeserializer() {
        super(ClientResourceFile.rEquipPreset);
    }

    private static EquipPreset readEntity(FileReader fileReader) {
        return new EquipPreset(fileReader.readUnsignedInteger());
    }

    @Override
    protected List<EquipPreset> readObject(FileReader fileReader) {
        return fileReader.readArray(EquipPresetDeserializer::readEntity);
    }
}
