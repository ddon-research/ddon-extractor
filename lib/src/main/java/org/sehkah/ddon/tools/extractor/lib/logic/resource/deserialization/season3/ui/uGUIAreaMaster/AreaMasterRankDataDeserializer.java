package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterRankData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterRankDataList;

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
