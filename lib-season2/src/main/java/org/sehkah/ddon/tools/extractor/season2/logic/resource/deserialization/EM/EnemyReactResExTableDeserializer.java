package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyReactRes;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyReactResEx;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.EnemyReactResExTable;

public class EnemyReactResExTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyReactResExTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyReactRes readEnemyReactRes(BufferReader bufferReader) {
        return new EnemyReactRes(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    private static EnemyReactResEx readEnemyReactResEx(BufferReader bufferReader) {
        return new EnemyReactResEx(
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readFixedLengthArray(2, BufferReader::readFloat),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFixedLengthArray(12, BufferReader::readBoolean),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readSignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedLong(),
                bufferReader.readArray(EnemyReactResExTableDeserializer::readEnemyReactRes)
        );
    }

    @Override
    protected EnemyReactResExTable parseClientResourceFile(BufferReader bufferReader) {
        return new EnemyReactResExTable(readEnemyReactResEx(bufferReader));
    }
}
