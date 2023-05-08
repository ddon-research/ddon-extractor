package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.MapSpotStageListData;

import java.util.List;

public class MapSpotStageListDeserializer extends FileDeserializer<List<MapSpotStageListData>> {
    public MapSpotStageListDeserializer() {
        super(ClientResourceFile.rMapSpotStageList);
    }

    private static MapSpotStageListData readEntity(FileReader fileReader) {
        return new MapSpotStageListData(fileReader.readSignedInteger());
    }

    @Override
    protected List<MapSpotStageListData> readObject(FileReader fileReader) {
        return fileReader.readArray(MapSpotStageListDeserializer::readEntity);
    }
}
