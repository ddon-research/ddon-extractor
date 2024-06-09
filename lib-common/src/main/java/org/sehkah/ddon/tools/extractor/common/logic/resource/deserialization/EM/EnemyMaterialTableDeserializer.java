package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EnemyMaterial;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.EnemyMaterialTable;

import java.nio.file.Path;

public class EnemyMaterialTableDeserializer extends ClientResourceFileDeserializer<EnemyMaterialTable> {


    private static EnemyMaterial readEnemyMaterialData(BufferReader bufferReader) {
        return new EnemyMaterial(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EnemyMaterialTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyMaterialTable(bufferReader.readArray(EnemyMaterialTableDeserializer::readEnemyMaterialData));
    }
}
