package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EnemyLocalEst;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.EM.EnemyLocalEstTable;

public class EnemyLocalEstTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyLocalEstTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected EnemyLocalEstTable parseClientResourceFile(BufferReader bufferReader) {
        return new EnemyLocalEstTable(bufferReader.readArray(EnemyLocalEstTableDeserializer::readEnemyLocalEst));
    }
}
