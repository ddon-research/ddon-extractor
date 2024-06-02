package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.MapSpotStageList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.MapSpotStageListData;

public class MapSpotStageListDeserializer extends ClientResourceFileDeserializer {
    public MapSpotStageListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MapSpotStageListData readMapSpotStageListData(BufferReader bufferReader) {
        return new MapSpotStageListData(bufferReader.readSignedInteger());
    }

    @Override
    protected MapSpotStageList parseClientResourceFile(BufferReader bufferReader) {
        return new MapSpotStageList(bufferReader.readArray(MapSpotStageListDeserializer::readMapSpotStageListData));
    }
}
