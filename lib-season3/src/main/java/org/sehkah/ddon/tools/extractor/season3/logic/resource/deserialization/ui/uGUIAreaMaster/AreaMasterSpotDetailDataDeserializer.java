package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailDataList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster.SpotItemData;

import java.nio.file.Path;
import java.util.List;

public class AreaMasterSpotDetailDataDeserializer extends ClientResourceFileDeserializer<AreaMasterSpotDetailDataList> {


    private static SpotEnemyData readSpotEnemyData(BufferReader bufferReader) {
        return new SpotEnemyData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    private static SpotItemData readSpotItemData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        int Unknown = bufferReader.readUnsignedShort();
        boolean IsFeature = bufferReader.readBoolean();
        boolean IsCannotPawnTake = bufferReader.readBoolean();

        Translation ItemName = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
        }

        return new SpotItemData(ItemId, ItemName, Unknown, IsCannotPawnTake, IsFeature);
    }

    private static AreaMasterSpotDetailData readAreaMasterSpotDetailData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long SpotId = bufferReader.readUnsignedInteger();
        List<SpotItemData> ItemArray = bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotItemData, lookupUtil);
        List<SpotEnemyData> EnemyArray = bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotEnemyData);

        Translation SpotName = null;
        if (lookupUtil != null) {
            SpotName = lookupUtil.getSpotName(SpotId);
        }

        return new AreaMasterSpotDetailData(SpotId, SpotName, ItemArray, EnemyArray);
    }

    @Override
    protected AreaMasterSpotDetailDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AreaMasterSpotDetailDataList(bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readAreaMasterSpotDetailData, lookupUtil));
    }
}
