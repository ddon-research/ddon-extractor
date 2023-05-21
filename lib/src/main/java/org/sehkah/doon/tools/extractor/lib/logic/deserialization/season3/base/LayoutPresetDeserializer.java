package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.LayoutPreset;

import java.util.List;

public class LayoutPresetDeserializer extends ClientResourceFileDeserializer<List<LayoutPreset>> {
    public LayoutPresetDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LayoutPreset readEntity(FileReader fileReader) {
        return new LayoutPreset(
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<LayoutPreset> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(LayoutPresetDeserializer::readEntity);
    }
}
