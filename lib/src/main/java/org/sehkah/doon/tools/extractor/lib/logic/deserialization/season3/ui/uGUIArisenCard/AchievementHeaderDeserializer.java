package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.uGUIArisenCard;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.uGUIArisenCard.AchievementHeaderData;

import java.util.List;

public class AchievementHeaderDeserializer extends ClientResourceFileDeserializer<List<AchievementHeaderData>> {
    public AchievementHeaderDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AchievementHeaderData readEntity(FileReader fileReader) {
        return new AchievementHeaderData(
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<AchievementHeaderData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AchievementHeaderDeserializer::readEntity);
    }
}
