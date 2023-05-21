package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.ui.uGUIAreaMaster.SpotItemData;

import java.util.List;

public class AreaMasterSpotDetailDataDeserializer extends ClientResourceFileDeserializer<List<AreaMasterSpotDetailData>> {
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

    private static AreaMasterSpotDetailData readEntity(FileReader fileReader) {
        return new AreaMasterSpotDetailData(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotItemData),
                fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotEnemyData)
        );
    }

    @Override
    protected List<AreaMasterSpotDetailData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readEntity);
    }
}
