package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.HumanEnemyEquip;

import java.util.List;

public class HumanEnemyEquipDeserializer extends ClientResourceFileDeserializer<List<HumanEnemyEquip>> {
    public HumanEnemyEquipDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static HumanEnemyEquip readEntity(FileReader fileReader) {
        return new HumanEnemyEquip(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<HumanEnemyEquip> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(HumanEnemyEquipDeserializer::readEntity);
    }
}
