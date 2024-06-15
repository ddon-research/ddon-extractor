package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.HumanEnemyEquip;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.HumanEnemyEquipList;

import java.nio.file.Path;

public class HumanEnemyEquipDeserializer extends ClientResourceFileDeserializer<HumanEnemyEquipList> {


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
    protected HumanEnemyEquipList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new HumanEnemyEquipList(bufferReader.readArray(HumanEnemyEquipDeserializer::readHumanEnemyEquip));
    }
}
