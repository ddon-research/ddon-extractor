package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.LayoutPreset;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.LayoutPresetList;

public class LayoutPresetDeserializer extends ClientResourceFileDeserializer {
    public LayoutPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LayoutPreset readLayoutPreset(BufferReader bufferReader) {
        return new LayoutPreset(
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected LayoutPresetList parseClientResourceFile(BufferReader bufferReader) {
        return new LayoutPresetList(bufferReader.readArray(LayoutPresetDeserializer::readLayoutPreset));
    }
}
