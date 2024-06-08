package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season3.StageAdjoinList;

import java.nio.file.Path;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer<Resource> {
    @Override
    protected Resource parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        if (fileHeader.versionNumber() == 3) {
            return new org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2.StageAdjoinList(
                    bufferReader.readSignedInteger(),
                    bufferReader.readArray(org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season2.StageAdjoinListDeserializer::readAdjoinInfo)
            );
        } else if (fileHeader.versionNumber() == 4) {
            return new StageAdjoinList(
                    bufferReader.readUnsignedShort(),
                    bufferReader.readArray(org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season3.StageAdjoinListDeserializer::readAdjoinInfo),
                    bufferReader.readArray(org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season3.StageAdjoinListDeserializer::readJumpPosition)
            );
        } else {
            throw new TechnicalException("SAL in unsupported version encountered in season2 unexpectedly: v" + fileHeader.versionNumber());
        }
    }
}
