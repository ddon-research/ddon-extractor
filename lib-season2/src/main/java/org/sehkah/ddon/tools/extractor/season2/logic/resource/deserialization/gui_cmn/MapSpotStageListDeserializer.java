package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.MapSpotStageList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.MapSpotStageListData;

public class MapSpotStageListDeserializer extends ClientResourceFileDeserializer {


    private static MapSpotStageListData readMapSpotStageListData(BufferReader bufferReader) {
        return new MapSpotStageListData(bufferReader.readSignedInteger());
    }

    @Override
    protected MapSpotStageList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new MapSpotStageList(bufferReader.readArray(MapSpotStageListDeserializer::readMapSpotStageListData));
    }
}
