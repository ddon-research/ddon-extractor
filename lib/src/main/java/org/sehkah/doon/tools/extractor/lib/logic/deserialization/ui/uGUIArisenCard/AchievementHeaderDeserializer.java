package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIArisenCard;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIArisenCard.AchievementHeaderData;

public class AchievementHeaderDeserializer extends FileDeserializer {
    public AchievementHeaderDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAchievementHeader, fileReader);
    }

    private static AchievementHeaderData readEntity(FileReader fileReader) {
        return new AchievementHeaderData(
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AchievementHeaderDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
