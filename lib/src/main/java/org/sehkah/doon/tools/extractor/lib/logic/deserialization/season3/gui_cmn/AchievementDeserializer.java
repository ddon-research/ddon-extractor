package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.AchievementData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.AchievementDataList;

public class AchievementDeserializer extends ClientResourceFileDeserializer {
    public AchievementDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AchievementData readAchievementData(FileReader fileReader) {
        return new AchievementData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected AchievementDataList parseClientResourceFile(FileReader fileReader) {
        return new AchievementDataList(fileReader.readArray(AchievementDeserializer::readAchievementData));
    }
}
