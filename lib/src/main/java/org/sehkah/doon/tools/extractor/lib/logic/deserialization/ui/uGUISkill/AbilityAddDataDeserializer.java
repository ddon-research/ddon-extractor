package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUISkill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUISkill.AbilityAddData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUISkill.AbilityLevelData;

public class AbilityAddDataDeserializer extends FileDeserializer {
    public AbilityAddDataDeserializer() {
        super(ClientResourceFile.rAbilityAddData);
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(AbilityAddDataDeserializer::readEntity);
    }
}
