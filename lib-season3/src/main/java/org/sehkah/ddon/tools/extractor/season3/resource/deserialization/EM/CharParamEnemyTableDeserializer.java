package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.EM.*;

public class CharParamEnemyTableDeserializer extends ClientResourceFileDeserializer {
    public CharParamEnemyTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static CharParamEnemyGuardCounter readCharParamEnemyGuardCounter(BufferReader bufferReader) {
        return new CharParamEnemyGuardCounter(
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    private static CharParamEnemyJumpAttackSpeed readCharParamEnemyJumpAttackSpeed(BufferReader bufferReader) {
        return new CharParamEnemyJumpAttackSpeed(
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    private static CharParamEnemy readCharParamEnemy(BufferReader bufferReader) {
        return new CharParamEnemy(
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFixedLengthArray(4, CharParamEnemyTableDeserializer::readCharParamEnemyJumpAttackSpeed),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedByte(),
                bufferReader.readFixedLengthArray(10, CharParamEnemyTableDeserializer::readCharParamEnemyGuardCounter),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readBoolean(),
                bufferReader.readFloat(),
                bufferReader.readArray(BufferReader::readFloat),
                bufferReader.readArray(BufferReader::readFloat),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    private static CharParamEnemyFly readCharParamEnemyFly(BufferReader bufferReader) {
        return new CharParamEnemyFly(
                readCharParamEnemy(bufferReader),
                bufferReader.readFloat(),
                bufferReader.readArray(BufferReader::readFloat),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat()
        );
    }

    @Override
    protected CharParamEnemyTable parseClientResourceFile(BufferReader bufferReader) {
        boolean FlgEnemyFly = bufferReader.readBoolean();
        CharParamEnemy CharParamEnemy;
        if (FlgEnemyFly) {
            CharParamEnemy = readCharParamEnemyFly(bufferReader);
        } else {
            CharParamEnemy = readCharParamEnemy(bufferReader);
        }
        float ScaleDispGui = bufferReader.readFloat();
        long Unknown1 = bufferReader.readUnsignedInteger();
        long Unknown2 = bufferReader.readUnsignedInteger();

        return new CharParamEnemyTable(
                FlgEnemyFly,
                CharParamEnemy,
                ScaleDispGui,
                Unknown1,
                Unknown2
        );
    }
}
