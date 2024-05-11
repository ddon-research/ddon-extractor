package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.ui.uGUIAreaMaster.AreaMasterSpotDetailDataList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.ui.uGUIAreaMaster.SpotItemData;

public class AreaMasterSpotDetailDataDeserializer extends ClientResourceFileDeserializer {
    public AreaMasterSpotDetailDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static SpotEnemyData readSpotEnemyData(FileReader fileReader) {
        return new SpotEnemyData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte()
        );
    }

    private static SpotItemData readSpotItemData(FileReader fileReader) {
        return new SpotItemData(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean()
        );
    }

    private static AreaMasterSpotDetailData readAreaMasterSpotDetailData(FileReader fileReader) {
        return new AreaMasterSpotDetailData(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotItemData),
                fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotEnemyData)
        );
    }

    @Override
    protected AreaMasterSpotDetailDataList parseClientResourceFile(FileReader fileReader) {
        return new AreaMasterSpotDetailDataList(fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readAreaMasterSpotDetailData));
    }
}
