package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.JumpPosition;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season3.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season3.StageAdjoinList;

import java.nio.file.Path;
import java.util.List;

public class StageAdjoinListDeserializer extends ClientResourceFileDeserializer<Resource> {
    @Override
    protected Resource parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        if (fileHeader.versionNumber() == 3) {
            int StageNo = bufferReader.readSignedInteger();
            List<org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2.AdjoinInfo> AdjoinInfoArray = bufferReader.readArray(org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season2.StageAdjoinListDeserializer::readAdjoinInfo, lookupUtil);

            Translation StageName = null;
            if (lookupUtil != null) {
                StageName = lookupUtil.getStageNameByStageNo(StageNo);
            }

            return new org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.marker.season2.StageAdjoinList(StageNo, StageName, AdjoinInfoArray);
        } else if (fileHeader.versionNumber() == 4) {
            int StageNo = bufferReader.readUnsignedShort();
            List<AdjoinInfo> AdjoinInfoArray = bufferReader.readArray(org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season3.StageAdjoinListDeserializer::readAdjoinInfo, lookupUtil);
            List<JumpPosition> JumpPositionArray = bufferReader.readArray(org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.marker.season3.StageAdjoinListDeserializer::readJumpPosition, lookupUtil);

            Translation StageName = null;
            if (lookupUtil != null) {
                StageName = lookupUtil.getStageNameByStageNo(StageNo);
            }

            return new StageAdjoinList(StageNo, StageName, AdjoinInfoArray, JumpPositionArray);
        } else {
            throw new TechnicalException("SAL in unsupported version encountered in season2 unexpectedly: v" + fileHeader.versionNumber());
        }
    }
}
