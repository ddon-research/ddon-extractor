package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EnemyMaterial;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EnemyMaterialTable;

public class EnemyMaterialTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyMaterialTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyMaterial readEnemyMaterialData(FileReader fileReader) {
        return new EnemyMaterial(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected EnemyMaterialTable parseClientResourceFile(FileReader fileReader) {
        return new EnemyMaterialTable(fileReader.readArray(EnemyMaterialTableDeserializer::readEnemyMaterialData));
    }
}
