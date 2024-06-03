package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.LayoutPreset;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.LayoutPresetList;

import java.util.ArrayList;
import java.util.List;

public class LayoutPresetDeserializer extends ClientResourceFileDeserializer {
    public LayoutPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LayoutPreset readLayoutPreset(BufferReader bufferReader, int presetNo) {
        return new LayoutPreset(
                presetNo,
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected LayoutPresetList parseClientResourceFile(BufferReader bufferReader) {
        int arraySize = (int) bufferReader.readUnsignedInteger();
        List<LayoutPreset> presets = new ArrayList<>(arraySize);
        for (int i = 0; i < arraySize; i++) {
            presets.add(readLayoutPreset(bufferReader, i));
        }
        return new LayoutPresetList(presets);
    }
}
