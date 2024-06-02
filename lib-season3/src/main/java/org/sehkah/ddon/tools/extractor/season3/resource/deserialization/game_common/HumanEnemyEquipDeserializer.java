package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.HumanEnemyEquip;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.HumanEnemyEquipList;

public class HumanEnemyEquipDeserializer extends ClientResourceFileDeserializer {
    public HumanEnemyEquipDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static HumanEnemyEquip readHumanEnemyEquip(BufferReader bufferReader) {
        return new HumanEnemyEquip(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected HumanEnemyEquipList parseClientResourceFile(BufferReader bufferReader) {
        return new HumanEnemyEquipList(bufferReader.readArray(HumanEnemyEquipDeserializer::readHumanEnemyEquip));
    }
}
