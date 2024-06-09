package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AbilityAddData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AbilityAddDataList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AbilityLevelData;

import java.nio.file.Path;

public class AbilityAddDataDeserializer extends ClientResourceFileDeserializer<AbilityAddDataList> {
    private static AbilityLevelData readAbilityLevelData(BufferReader bufferReader) {
        return new AbilityLevelData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static AbilityAddData readAbilityAddData(BufferReader bufferReader) {
        return new AbilityAddData(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readArray(AbilityAddDataDeserializer::readAbilityLevelData)
        );
    }

    @Override
    protected AbilityAddDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AbilityAddDataList(bufferReader.readArray(AbilityAddDataDeserializer::readAbilityAddData));
    }
}
