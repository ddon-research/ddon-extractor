package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.GUIMessageLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.AchievementData;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.AchievementDataList;

import java.nio.file.Path;

public class AchievementDeserializer extends ClientResourceFileDeserializer<AchievementDataList> {
    private static AchievementData readAchievementData(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        long ID = bufferReader.readUnsignedInteger();
        long TargetNum = bufferReader.readUnsignedInteger();
        long MessageIndex = bufferReader.readUnsignedInteger();
        int Category = bufferReader.readUnsignedByte();
        Translation AchievementName = null;
        Translation AchievementInfo = null;
        Translation AchievementCategoryName = null;
        if (lookupUtil != null) {
            AchievementName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ACHIEVEMENT_NAME.getFilePath(), (int) MessageIndex);
            AchievementInfo = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ACHIEVEMENT_INFO.getFilePath(), (int) MessageIndex);
            AchievementCategoryName = lookupUtil.getMessageTranslation(GUIMessageLookupTable.ACHIEVEMENT_CATEGORY.getFilePath(), "ACHIEVEMENT_CATEGORY_" + Category);
        }
        int Trophy = bufferReader.readUnsignedByte();

        return new AchievementData(ID, TargetNum, MessageIndex, AchievementName, AchievementInfo, Category, AchievementCategoryName, Trophy);
    }

    @Override
    protected AchievementDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AchievementDataList(bufferReader.readArray(AchievementDeserializer::readAchievementData, lookupUtil));
    }
}
