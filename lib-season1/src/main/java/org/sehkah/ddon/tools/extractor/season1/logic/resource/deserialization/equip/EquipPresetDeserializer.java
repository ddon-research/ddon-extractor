package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.equip;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.equip.EquipPreset;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.equip.EquipPresetList;

import java.nio.file.Path;

public class EquipPresetDeserializer extends ClientResourceFileDeserializer<EquipPresetList> {


    private static EquipPreset readEquipPreset(BufferReader bufferReader) {
        return new EquipPreset(bufferReader.readUnsignedInteger());
    }

    @Override
    protected EquipPresetList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EquipPresetList(bufferReader.readArray(EquipPresetDeserializer::readEquipPreset));
    }
}
