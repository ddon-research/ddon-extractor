package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.ui;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AreaMasterRankData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.AreaMasterRankDataList;

import java.nio.file.Path;

public class AreaMasterRankDataDeserializer extends ClientResourceFileDeserializer<AreaMasterRankDataList> {
    private static AreaMasterRankData readAreaMasterRankData(BufferReader bufferReader) {
        return new AreaMasterRankData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected AreaMasterRankDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaMasterRankDataList(bufferReader.readArray(AreaMasterRankDataDeserializer::readAreaMasterRankData));
    }
}
