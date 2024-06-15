package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleContentsSortieInfoTable;

import java.nio.file.Path;

public class CycleContentsSortieInfoDeserializer extends ClientResourceFileDeserializer<CycleContentsSortieInfoTable> {


    private static CycleContentsSortieInfoData readCycleContentsSortieInfoData(BufferReader bufferReader) {
        return new CycleContentsSortieInfoData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected CycleContentsSortieInfoTable parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CycleContentsSortieInfoTable(bufferReader.readArray(CycleContentsSortieInfoDeserializer::readCycleContentsSortieInfoData));
    }
}
