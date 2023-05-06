package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUISkill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUISkill.AbilityAddData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUISkill.AbilityLevelData;

public class AbilityAddDataDeserializer extends FileDeserializer {
    public AbilityAddDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAbilityAddData, fileReader);
    }

    private static AbilityLevelData readAbilityLevelData(FileReader fileReader) {
        return new AbilityLevelData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger()
        );
    }

    private static AbilityAddData readEntity(FileReader fileReader) {
        return new AbilityAddData(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(AbilityAddDataDeserializer::readAbilityLevelData)
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AbilityAddDataDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
