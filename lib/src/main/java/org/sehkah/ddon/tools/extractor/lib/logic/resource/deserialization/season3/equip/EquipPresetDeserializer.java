package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.equip;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.equip.EquipPreset;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.equip.EquipPresetList;

public class EquipPresetDeserializer extends ClientResourceFileDeserializer {
    public EquipPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EquipPreset readEquipPreset(BufferReader bufferReader) {
        return new EquipPreset(bufferReader.readUnsignedInteger());
    }

    @Override
    protected EquipPresetList parseClientResourceFile(BufferReader bufferReader) {
        return new EquipPresetList(bufferReader.readArray(EquipPresetDeserializer::readEquipPreset));
    }
}
