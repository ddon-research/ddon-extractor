package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.AchievementData;

public class AchievementDeserializer extends FileDeserializer {
    public AchievementDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAchievement, fileReader);
    }

    private static AchievementData readEntity(FileReader fileReader) {
        return new AchievementData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(AchievementDeserializer::readEntity);
    }
}
