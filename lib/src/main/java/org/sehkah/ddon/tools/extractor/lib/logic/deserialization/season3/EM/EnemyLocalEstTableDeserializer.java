package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyLocalEst;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyLocalEstTable;

public class EnemyLocalEstTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyLocalEstTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyLocalEst readEnemyLocalEst(FileReader fileReader) {
        return new EnemyLocalEst(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected EnemyLocalEstTable parseClientResourceFile(FileReader fileReader) {
        return new EnemyLocalEstTable(fileReader.readArray(EnemyLocalEstTableDeserializer::readEnemyLocalEst));
    }
}
