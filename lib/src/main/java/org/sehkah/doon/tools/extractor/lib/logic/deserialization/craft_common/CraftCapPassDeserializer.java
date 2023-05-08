package org.sehkah.doon.tools.extractor.lib.logic.deserialization.craft_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.craft_common.CraftCapPassData;

import java.util.List;

public class CraftCapPassDeserializer extends FileDeserializer<List<CraftCapPassData>> {
    public CraftCapPassDeserializer() {
        super(ClientResourceFile.rCraftCapPass);
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
    protected List<CraftCapPassData> readObject(FileReader fileReader) {
        return fileReader.readArray(CraftCapPassDeserializer::readEntity);
    }
}
