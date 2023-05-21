package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster.AreaMasterRankData;

import java.util.List;

public class AreaMasterRankDataDeserializer extends ClientResourceFileDeserializer<List<AreaMasterRankData>> {
    public AreaMasterRankDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaMasterRankData readEntity(FileReader fileReader) {
        return new AreaMasterRankData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<AreaMasterRankData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AreaMasterRankDataDeserializer::readEntity);
    }
}
