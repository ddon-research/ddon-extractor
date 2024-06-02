package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.LayoutPreset;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.base.LayoutPresetList;

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
