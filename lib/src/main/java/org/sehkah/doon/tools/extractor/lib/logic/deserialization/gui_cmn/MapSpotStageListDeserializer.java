package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.MapSpotStageListData;

public class MapSpotStageListDeserializer extends FileDeserializer {
    public MapSpotStageListDeserializer(FileReader fileReader) {
        super(ExtensionMap.rMapSpotStageList, fileReader);
    }

    private static MapSpotStageListData readEntity(FileReader fileReader) {
        return new MapSpotStageListData(
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(MapSpotStageListDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
