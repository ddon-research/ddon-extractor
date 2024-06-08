package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUISkill;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUISkill.AbilityAddData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUISkill.AbilityAddDataList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUISkill.AbilityLevelData;

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
