package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyLocalEst;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyLocalEstTable;

import java.nio.file.Path;

public class EnemyLocalEstTableDeserializer extends ClientResourceFileDeserializer<EnemyLocalEstTable> {


    private static EnemyLocalEst readEnemyLocalEst(BufferReader bufferReader) {
        return new EnemyLocalEst(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EnemyLocalEstTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyLocalEstTable(bufferReader.readArray(EnemyLocalEstTableDeserializer::readEnemyLocalEst));
    }
}
