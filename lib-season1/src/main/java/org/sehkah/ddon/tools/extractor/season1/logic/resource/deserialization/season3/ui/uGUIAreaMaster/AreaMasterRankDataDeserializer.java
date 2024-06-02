package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterRankData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterRankDataList;

public class AreaMasterRankDataDeserializer extends ClientResourceFileDeserializer {
    public AreaMasterRankDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaMasterRankData readAreaMasterRankData(BufferReader bufferReader) {
        return new AreaMasterRankData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected AreaMasterRankDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AreaMasterRankDataList(bufferReader.readArray(AreaMasterRankDataDeserializer::readAreaMasterRankData));
    }
}
