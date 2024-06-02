package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.ui.uGUIArisenCard;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIArisenCard.AchievementHeader;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIArisenCard.AchievementHeaderData;

public class AchievementHeaderDeserializer extends ClientResourceFileDeserializer {
    public AchievementHeaderDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AchievementHeaderData readAchievementHeaderData(BufferReader bufferReader) {
        return new AchievementHeaderData(bufferReader.readUnsignedInteger());
    }

    @Override
    protected AchievementHeader parseClientResourceFile(BufferReader bufferReader) {
        return new AchievementHeader(bufferReader.readArray(AchievementHeaderDeserializer::readAchievementHeaderData));
    }
}
