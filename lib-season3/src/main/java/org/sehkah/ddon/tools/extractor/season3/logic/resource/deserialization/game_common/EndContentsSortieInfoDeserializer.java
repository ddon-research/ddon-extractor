package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EndContentsSortieInfoData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.EndContentsSortieInfoTable;

public class EndContentsSortieInfoDeserializer extends ClientResourceFileDeserializer<EndContentsSortieInfoTable> {


    private static EndContentsSortieInfoData readEndContentsSortieInfoData(BufferReader bufferReader) {
        return new EndContentsSortieInfoData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected EndContentsSortieInfoTable parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new EndContentsSortieInfoTable(bufferReader.readArray(EndContentsSortieInfoDeserializer::readEndContentsSortieInfoData));
    }
}
