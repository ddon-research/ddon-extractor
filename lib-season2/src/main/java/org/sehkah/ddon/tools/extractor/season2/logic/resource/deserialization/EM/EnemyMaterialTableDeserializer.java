package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyMaterial;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyMaterialTable;

public class EnemyMaterialTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyMaterialTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected EnemyMaterialTable parseClientResourceFile(BufferReader bufferReader) {
        return new EnemyMaterialTable(bufferReader.readArray(EnemyMaterialTableDeserializer::readEnemyMaterialData));
    }
}
