package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.PartsCtrlData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM.PartsCtrlTable;

public class PartsCtrlTableDeserializer extends ClientResourceFileDeserializer {
    public PartsCtrlTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static PartsCtrlData readPartsCtrlData(BufferReader bufferReader) {
        return new PartsCtrlData(
                bufferReader.readSignedInteger(),
                bufferReader.readFixedLengthArray(16, BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected PartsCtrlTable parseClientResourceFile(BufferReader bufferReader) {
        return new PartsCtrlTable(bufferReader.readArray(PartsCtrlTableDeserializer::readPartsCtrlData));
    }
}
