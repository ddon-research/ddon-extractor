package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.HumanEnemyEquip;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.HumanEnemyEquipList;

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
