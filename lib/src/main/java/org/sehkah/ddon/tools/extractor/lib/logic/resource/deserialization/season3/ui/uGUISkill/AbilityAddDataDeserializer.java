package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.uGUISkill;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill.AbilityAddData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill.AbilityAddDataList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill.AbilityLevelData;

public class AbilityAddDataDeserializer extends ClientResourceFileDeserializer {
    public AbilityAddDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected AbilityAddDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AbilityAddDataList(bufferReader.readArray(AbilityAddDataDeserializer::readAbilityAddData));
    }
}
