package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.HumanEnemyEquip;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.game_common.HumanEnemyEquipList;

public class HumanEnemyEquipDeserializer extends ClientResourceFileDeserializer {
    public HumanEnemyEquipDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static HumanEnemyEquip readHumanEnemyEquip(FileReader fileReader) {
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
    protected HumanEnemyEquipList parseClientResourceFile(FileReader fileReader) {
        return new HumanEnemyEquipList(fileReader.readArray(HumanEnemyEquipDeserializer::readHumanEnemyEquip));
    }
}
