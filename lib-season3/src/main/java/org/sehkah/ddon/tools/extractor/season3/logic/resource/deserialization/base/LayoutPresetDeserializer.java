package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.LayoutPreset;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.LayoutPresetList;

import java.util.ArrayList;
import java.util.List;

public class LayoutPresetDeserializer extends ClientResourceFileDeserializer<LayoutPresetList> {


    private static LayoutPreset readLayoutPreset(BufferReader bufferReader, int presetNo) {
        return new LayoutPreset(
                presetNo,
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected LayoutPresetList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        int arraySize = (int) bufferReader.readUnsignedInteger();
        List<LayoutPreset> presets = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            presets.add(readLayoutPreset(bufferReader, i));
        }
        return new LayoutPresetList(presets);
    }
}
