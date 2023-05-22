package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn.MapSpotStageList;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn.MapSpotStageListData;

public class MapSpotStageListDeserializer extends ClientResourceFileDeserializer {
    public MapSpotStageListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MapSpotStageListData readMapSpotStageListData(FileReader fileReader) {
        return new MapSpotStageListData(fileReader.readSignedInteger());
    }

    @Override
    protected MapSpotStageList parseClientResourceFile(FileReader fileReader) {
        return new MapSpotStageList(fileReader.readArray(MapSpotStageListDeserializer::readMapSpotStageListData));
    }
}
