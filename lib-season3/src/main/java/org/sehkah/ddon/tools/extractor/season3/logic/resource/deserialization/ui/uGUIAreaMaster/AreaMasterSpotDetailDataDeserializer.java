package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailDataList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.SpotItemData;

public class AreaMasterSpotDetailDataDeserializer extends ClientResourceFileDeserializer {
    public AreaMasterSpotDetailDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static SpotEnemyData readSpotEnemyData(BufferReader bufferReader) {
        return new SpotEnemyData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    private static SpotItemData readSpotItemData(BufferReader bufferReader) {
        return new SpotItemData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readBoolean(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    private static AreaMasterSpotDetailData readAreaMasterSpotDetailData(BufferReader bufferReader) {
        return new AreaMasterSpotDetailData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotItemData),
                bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotEnemyData)
        );
    }

    @Override
    protected AreaMasterSpotDetailDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AreaMasterSpotDetailDataList(bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readAreaMasterSpotDetailData));
    }
}
