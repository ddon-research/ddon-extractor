package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.uGUISkill;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUISkill.AbilityAddData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUISkill.AbilityLevelData;

import java.util.List;

public class AbilityAddDataDeserializer extends ClientResourceFileDeserializer<List<AbilityAddData>> {
    public AbilityAddDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
    protected List<AbilityAddData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AbilityAddDataDeserializer::readEntity);
    }
}
