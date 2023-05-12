package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.HumanEnemyEquip;

import java.util.List;

public class HumanEnemyEquipDeserializer extends FileDeserializer<List<HumanEnemyEquip>> {
    public HumanEnemyEquipDeserializer() {
        super(ClientResourceFile.rHumanEnemyEquip);
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
    protected List<HumanEnemyEquip> readObject(FileReader fileReader) {
        return fileReader.readArray(HumanEnemyEquipDeserializer::readEntity);
    }
}
