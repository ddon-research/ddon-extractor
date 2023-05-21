package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.MapSpotStageListData;

import java.util.List;

public class MapSpotStageListDeserializer extends ClientResourceFileDeserializer<List<MapSpotStageListData>> {
    public MapSpotStageListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MapSpotStageListData readEntity(FileReader fileReader) {
        return new MapSpotStageListData(fileReader.readSignedInteger());
    }

    @Override
    protected List<MapSpotStageListData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(MapSpotStageListDeserializer::readEntity);
    }
}
