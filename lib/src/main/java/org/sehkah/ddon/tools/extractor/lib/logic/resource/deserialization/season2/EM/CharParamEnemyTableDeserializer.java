package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.EM.*;

public class CharParamEnemyTableDeserializer extends ClientResourceFileDeserializer {
    public CharParamEnemyTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }


    private static CharParamEnemyGuardCounter readCharParamEnemyGuardCounter(FileReader fileReader) {
        return new CharParamEnemyGuardCounter(
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    private static CharParamEnemyJumpAttackSpeed readCharParamEnemyJumpAttackSpeed(FileReader fileReader) {
        return new CharParamEnemyJumpAttackSpeed(
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    private static CharParamEnemy readCharParamEnemy(FileReader fileReader) {
        return new CharParamEnemy(
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFixedLengthArray(4, CharParamEnemyTableDeserializer::readCharParamEnemyJumpAttackSpeed),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedByte(),
                fileReader.readFixedLengthArray(10, CharParamEnemyTableDeserializer::readCharParamEnemyGuardCounter),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readArray(FileReader::readFloat),
                fileReader.readArray(FileReader::readFloat),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    private static CharParamEnemyFly readCharParamEnemyFly(FileReader fileReader) {
        return new CharParamEnemyFly(
                readCharParamEnemy(fileReader),
                fileReader.readFloat(),
                fileReader.readArray(FileReader::readFloat),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat()
        );
    }

    @Override
    protected CharParamEnemyTable parseClientResourceFile(FileReader fileReader) {
        boolean FlgEnemyFly = fileReader.readBoolean();
        CharParamEnemy CharParamEnemy;
        if (FlgEnemyFly) {
            CharParamEnemy = readCharParamEnemyFly(fileReader);
        } else {
            CharParamEnemy = readCharParamEnemy(fileReader);
        }
        float ScaleDispGui = fileReader.readFloat();

        return new CharParamEnemyTable(
                FlgEnemyFly,
                CharParamEnemy,
                ScaleDispGui
        );
    }
}
