package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyStatusChange;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.EnemyStatusChangeTable;

public class EnemyStatusChangeTableDeserializer extends ClientResourceFileDeserializer {
    public EnemyStatusChangeTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EnemyStatusChange readEnemyStatusChangeData(FileReader fileReader) {
        return new EnemyStatusChange(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(2, FileReader::readFloat),
                fileReader.readFixedLengthArray(3, FileReader::readFloat),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected EnemyStatusChangeTable parseClientResourceFile(FileReader fileReader) {
        return new EnemyStatusChangeTable(fileReader.readArray(EnemyStatusChangeTableDeserializer::readEnemyStatusChangeData));
    }
}
