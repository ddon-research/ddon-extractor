package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyReactRes;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyReactResEx;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyReactResExTable;

public class EnemyReactResExTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyReactResExTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyReactRes readEnemyReactRes(FileReader fileReader) {
        return new EnemyReactRes(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    private static EnemyReactResEx readEnemyReactResEx(FileReader fileReader) {
        return new EnemyReactResEx(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFixedLengthArray(2, FileReader::readFloat),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(12, FileReader::readBoolean),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readArray(EnemyReactResExTableDeserializer::readEnemyReactRes)
        );
    }

    @Override
    protected EnemyReactResExTable parseClientResourceFile(FileReader fileReader) {
        return new EnemyReactResExTable(readEnemyReactResEx(fileReader));
    }
}
