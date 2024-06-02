package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyStatusChange;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyStatusChangeTable;

public class EnemyStatusChangeTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyStatusChangeTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyStatusChange readEnemyStatusChangeData(BufferReader bufferReader) {
        return new EnemyStatusChange(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(2, BufferReader::readFloat),
                bufferReader.readFixedLengthArray(3, BufferReader::readFloat),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EnemyStatusChangeTable parseClientResourceFile(BufferReader bufferReader) {
        return new EnemyStatusChangeTable(bufferReader.readArray(EnemyStatusChangeTableDeserializer::readEnemyStatusChangeData));
    }
}
