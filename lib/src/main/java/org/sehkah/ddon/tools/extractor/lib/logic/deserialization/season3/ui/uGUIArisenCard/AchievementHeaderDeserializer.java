package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIArisenCard;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIArisenCard.AchievementHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.ui.uGUIArisenCard.AchievementHeaderData;

public class AchievementHeaderDeserializer extends ClientResourceFileDeserializer {
    public AchievementHeaderDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AchievementHeaderData readAchievementHeaderData(FileReader fileReader) {
        return new AchievementHeaderData(fileReader.readUnsignedInteger());
    }

    @Override
    protected AchievementHeader parseClientResourceFile(FileReader fileReader) {
        return new AchievementHeader(fileReader.readArray(AchievementHeaderDeserializer::readAchievementHeaderData));
    }
}
