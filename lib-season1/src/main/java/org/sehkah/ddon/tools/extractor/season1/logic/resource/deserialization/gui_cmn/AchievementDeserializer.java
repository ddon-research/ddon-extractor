package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceFileLookupType;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.AchievementData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.AchievementDataList;

public class AchievementDeserializer extends ClientResourceFileDeserializer<AchievementDataList> {
    private static AchievementData readAchievementData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        long TargetNum = bufferReader.readUnsignedInteger();
        long MessageIndex = bufferReader.readUnsignedInteger();
        int Category = bufferReader.readUnsignedByte();
        String AchievementName = null;
        String AchievementInfo = null;
        String AchievementCategoryName = null;
        if (lookupUtil != null) {
            AchievementName = lookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_NAME.getFilePath(), MessageIndex);
            AchievementInfo = lookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_INFO.getFilePath(), MessageIndex);
            AchievementCategoryName = lookupUtil.getMessage(ResourceFileLookupType.ACHIEVEMENT_CATEGORY.getFilePath(), "ACHIEVEMENT_CATEGORY_" + Category);
        }
        int Trophy = bufferReader.readUnsignedByte();

        return new AchievementData(ID, TargetNum, MessageIndex, AchievementName, AchievementInfo, Category, AchievementCategoryName, Trophy);
    }

    @Override
    protected AchievementDataList parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AchievementDataList(bufferReader.readArray(AchievementDeserializer::readAchievementData, lookupUtil));
    }
}
