package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EnemyMaterial;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EnemyMaterialTable;

public class EnemyMaterialTableDeserializer extends ClientResourceFileDeserializer {


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
    protected EnemyMaterialTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyMaterialTable(bufferReader.readArray(EnemyMaterialTableDeserializer::readEnemyMaterialData));
    }
}
