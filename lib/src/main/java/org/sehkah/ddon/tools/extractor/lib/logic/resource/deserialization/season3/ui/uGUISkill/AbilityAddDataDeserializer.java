package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.uGUISkill;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill.AbilityAddData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill.AbilityAddDataList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUISkill.AbilityLevelData;

public class AbilityAddDataDeserializer extends ClientResourceFileDeserializer {
    public AbilityAddDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AbilityLevelData readAbilityLevelData(FileReader fileReader) {
        return new AbilityLevelData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger()
        );
    }

    private static AbilityAddData readAbilityAddData(FileReader fileReader) {
        return new AbilityAddData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(AbilityAddDataDeserializer::readAbilityLevelData)
        );
    }

    @Override
    protected AbilityAddDataList parseClientResourceFile(FileReader fileReader) {
        return new AbilityAddDataList(fileReader.readArray(AbilityAddDataDeserializer::readAbilityAddData));
    }
}
