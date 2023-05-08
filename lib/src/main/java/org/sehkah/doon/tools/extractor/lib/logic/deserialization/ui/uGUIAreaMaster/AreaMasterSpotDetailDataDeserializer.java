package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster.SpotItemData;

public class AreaMasterSpotDetailDataDeserializer extends FileDeserializer {
    public AreaMasterSpotDetailDataDeserializer() {
        super(ClientResourceFile.rAreaMasterSpotDetailData);
    }

    private static SpotEnemyData readSpotEnemyData(FileReader fileReader) {
        return new SpotEnemyData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte()
        );
    }

    private static SpotItemData readSpotItemData(FileReader fileReader) {
        return new SpotItemData(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(AreaMasterSpotDetailDataDeserializer::readEntity);
    }
}
