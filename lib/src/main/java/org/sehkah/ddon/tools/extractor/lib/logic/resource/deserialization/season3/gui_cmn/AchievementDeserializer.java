package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.AchievementData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.gui_cmn.AchievementDataList;

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
