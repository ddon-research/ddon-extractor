package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EnemyStatusChange;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.EM.EnemyStatusChangeTable;

public class EnemyStatusChangeTableDeserializer extends ClientResourceFileDeserializer {


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
    protected EnemyStatusChangeTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EnemyStatusChangeTable(bufferReader.readArray(EnemyStatusChangeTableDeserializer::readEnemyStatusChangeData));
    }
}
