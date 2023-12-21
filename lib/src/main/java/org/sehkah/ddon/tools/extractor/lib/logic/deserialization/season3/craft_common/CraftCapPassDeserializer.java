package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.craft_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.craft_common.CraftCapPassData;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.craft_common.CraftCapPassList;

public class CraftCapPassDeserializer extends ClientResourceFileDeserializer {
    public CraftCapPassDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CraftCapPassData readCraftCapPassData(FileReader fileReader) {
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
    protected CraftCapPassList parseClientResourceFile(FileReader fileReader) {
        return new CraftCapPassList(fileReader.readArray(CraftCapPassDeserializer::readCraftCapPassData));
    }
}
