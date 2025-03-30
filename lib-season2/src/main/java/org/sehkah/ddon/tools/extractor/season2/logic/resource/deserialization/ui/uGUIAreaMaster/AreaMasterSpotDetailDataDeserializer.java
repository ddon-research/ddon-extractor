package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.AreaMasterSpotDetailDataList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.SpotEnemyData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster.SpotItemData;

import java.nio.file.Path;
import java.util.List;

public class AreaMasterSpotDetailDataDeserializer extends ClientResourceFileDeserializer<AreaMasterSpotDetailDataList> {
    private static SpotEnemyData readSpotEnemyData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long EnemyGroupId = bufferReader.readUnsignedInteger();
        long EnemyNamedId = bufferReader.readUnsignedInteger();
        int Level = bufferReader.readUnsignedShort();
        int Rank = bufferReader.readUnsignedByte();

        Translation EnemyName = null;
        Translation NamedEnemyName = null;
        if (lookupUtil != null) {
            EnemyName = lookupUtil.getEnemyGroupName(EnemyGroupId);
            NamedEnemyName = lookupUtil.getNamedEnemyName(EnemyNamedId);
        }

        return new SpotEnemyData(EnemyGroupId, EnemyName, EnemyNamedId, NamedEnemyName, Level, Rank);
    }

    private static SpotItemData readSpotItemData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ItemId = bufferReader.readUnsignedInteger();
        Translation ItemName = null;
        if (lookupUtil != null) {
            ItemName = lookupUtil.getItemName(ItemId);
        }
        boolean IsFeature = bufferReader.readBoolean();
        boolean IsCannotPawnTake = bufferReader.readBoolean();

        return new SpotItemData(ItemId, ItemName, IsFeature, IsCannotPawnTake);
    }

    private static AreaMasterSpotDetailData readAreaMasterSpotDetailData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long SpotId = bufferReader.readUnsignedInteger();
        List<SpotItemData> ItemArray = bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotItemData, lookupUtil);
        List<SpotEnemyData> EnemyArray = bufferReader.readArray(AreaMasterSpotDetailDataDeserializer::readSpotEnemyData, lookupUtil);
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
