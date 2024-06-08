package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.EM.*;

import java.nio.file.Path;

public class CharParamEnemyTableDeserializer extends ClientResourceFileDeserializer<CharParamEnemyTable> {


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
    protected CharParamEnemyTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        boolean FlgEnemyFly = bufferReader.readBoolean();
        CharParamEnemy CharParamEnemy;
        if (FlgEnemyFly) {
            CharParamEnemy = readCharParamEnemyFly(bufferReader);
        } else {
            CharParamEnemy = readCharParamEnemy(bufferReader);
        }
        float ScaleDispGui = bufferReader.readFloat();

        return new CharParamEnemyTable(
                FlgEnemyFly,
                CharParamEnemy,
                ScaleDispGui
        );
    }
}
