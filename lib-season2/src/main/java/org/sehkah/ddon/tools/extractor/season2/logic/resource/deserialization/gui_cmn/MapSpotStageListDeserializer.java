package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.MapSpotStageList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.MapSpotStageListData;

import java.nio.file.Path;

public class MapSpotStageListDeserializer extends ClientResourceFileDeserializer<MapSpotStageList> {
    private static MapSpotStageListData readMapSpotStageListData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        int StageNo = bufferReader.readSignedInteger();
        Translation StageName = null;
        if (lookupUtil != null) {
            StageName = lookupUtil.getStageNameByStageNo(StageNo);
        }

        return new MapSpotStageListData(StageNo, StageName);
    }

    @Override
    protected MapSpotStageList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new MapSpotStageList(bufferReader.readArray(MapSpotStageListDeserializer::readMapSpotStageListData, lookupUtil));
    }
}
