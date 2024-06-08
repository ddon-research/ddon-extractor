package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.ui.uGUIArisenCard;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIArisenCard.AchievementHeader;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIArisenCard.AchievementHeaderData;

import java.nio.file.Path;

public class AchievementHeaderDeserializer extends ClientResourceFileDeserializer<AchievementHeader> {


    private static AchievementHeaderData readAchievementHeaderData(BufferReader bufferReader) {
        return new AchievementHeaderData(bufferReader.readUnsignedInteger());
    }

    @Override
    protected AchievementHeader parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new AchievementHeader(bufferReader.readArray(AchievementHeaderDeserializer::readAchievementHeaderData));
    }
}
