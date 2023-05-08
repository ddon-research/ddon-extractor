package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LayoutPreset;

import java.util.List;

public class LayoutPresetDeserializer extends FileDeserializer<List<LayoutPreset>> {
    public LayoutPresetDeserializer() {
        super(ClientResourceFile.rLayoutPreset);
    }

    private static LayoutPreset readEntity(FileReader fileReader) {
        return new LayoutPreset(
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<LayoutPreset> readObject(FileReader fileReader) {
        return fileReader.readArray(LayoutPresetDeserializer::readEntity);
    }
}
