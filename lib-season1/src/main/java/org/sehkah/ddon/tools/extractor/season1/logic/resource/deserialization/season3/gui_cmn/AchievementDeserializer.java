package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn.AchievementData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn.AchievementDataList;

public class AchievementDeserializer extends ClientResourceFileDeserializer {
    public AchievementDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AchievementData readAchievementData(BufferReader bufferReader) {
        return new AchievementData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected AchievementDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AchievementDataList(bufferReader.readArray(AchievementDeserializer::readAchievementData));
    }
}
