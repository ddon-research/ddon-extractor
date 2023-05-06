package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftCapPassData;

public class CraftCapPassDeserializer extends FileDeserializer {
    public CraftCapPassDeserializer(FileReader fileReader) {
        super(ExtensionMap.rCraftCapPass, fileReader);
    }

    private static CraftCapPassData readEntity(FileReader fileReader) {
        return new CraftCapPassData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readSignedByte(),
                fileReader.readSignedByte()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(CraftCapPassDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
