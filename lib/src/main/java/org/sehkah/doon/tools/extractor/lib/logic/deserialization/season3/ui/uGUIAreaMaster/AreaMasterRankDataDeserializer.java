package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster.AreaMasterRankData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIAreaMaster.AreaMasterRankDataList;

public class AreaMasterRankDataDeserializer extends ClientResourceFileDeserializer {
    public AreaMasterRankDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaMasterRankData readAreaMasterRankData(FileReader fileReader) {
        return new AreaMasterRankData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected AreaMasterRankDataList parseClientResourceFile(FileReader fileReader) {
        return new AreaMasterRankDataList(fileReader.readArray(AreaMasterRankDataDeserializer::readAreaMasterRankData));
    }
}
