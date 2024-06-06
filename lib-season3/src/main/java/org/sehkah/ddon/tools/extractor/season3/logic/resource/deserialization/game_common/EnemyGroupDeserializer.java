package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EnemyGroupList;

public class EnemyGroupDeserializer extends ClientResourceFileDeserializer {


    private static EnemyGroup readEnemyGroup(BufferReader bufferReader) {
        return new EnemyGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected EnemyGroupList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyGroupList(bufferReader.readArray(EnemyGroupDeserializer::readEnemyGroup));
    }
}
