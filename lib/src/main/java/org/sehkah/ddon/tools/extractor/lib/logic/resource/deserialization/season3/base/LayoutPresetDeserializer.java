package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.LayoutPreset;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.LayoutPresetList;

public class LayoutPresetDeserializer extends ClientResourceFileDeserializer {
    public LayoutPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LayoutPreset readLayoutPreset(FileReader fileReader) {
        return new LayoutPreset(
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected LayoutPresetList parseClientResourceFile(FileReader fileReader) {
        return new LayoutPresetList(fileReader.readArray(LayoutPresetDeserializer::readLayoutPreset));
    }
}
