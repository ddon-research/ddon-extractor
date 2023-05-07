package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LayoutPreset;

public class LayoutPresetDeserializer extends FileDeserializer {
    public LayoutPresetDeserializer(FileReader fileReader) {
        super(ExtensionMap.rLayoutPreset, fileReader);
    }

    private static LayoutPreset readEntity(FileReader fileReader) {
        return new LayoutPreset(
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(LayoutPresetDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
