package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.EM;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.PartsCtrlData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.EM.PartsCtrlTable;

import java.nio.file.Path;

public class PartsCtrlTableDeserializer extends ClientResourceFileDeserializer<PartsCtrlTable> {
    private static PartsCtrlData readPartsCtrlData(BufferReader bufferReader) {
        return new PartsCtrlData(
                bufferReader.readSignedInteger(),
                bufferReader.readFixedLengthArray(16, BufferReader::readUnsignedInteger)
        );
    }

    @Override
    protected PartsCtrlTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PartsCtrlTable(bufferReader.readArray(PartsCtrlTableDeserializer::readPartsCtrlData));
    }
}
