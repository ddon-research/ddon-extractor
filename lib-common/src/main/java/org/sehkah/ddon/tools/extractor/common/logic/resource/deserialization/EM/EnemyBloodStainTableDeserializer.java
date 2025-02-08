package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EnemyBloodStain;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EnemyBloodStainTable;

import java.nio.file.Path;

public class EnemyBloodStainTableDeserializer extends ClientResourceFileDeserializer<EnemyBloodStainTable> {
    private static EnemyBloodStain readEnemyBloodStain(BufferReader bufferReader) {
        return new EnemyBloodStain(
                bufferReader.readSignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected EnemyBloodStainTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyBloodStainTable(bufferReader.readArray(EnemyBloodStainTableDeserializer::readEnemyBloodStain));
    }
}
