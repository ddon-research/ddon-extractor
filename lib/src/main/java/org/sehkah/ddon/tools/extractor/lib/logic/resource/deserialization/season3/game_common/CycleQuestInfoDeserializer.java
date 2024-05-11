package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CycleQuestInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CycleQuestInfoList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.CycleQuestSituationInfo;

public class CycleQuestInfoDeserializer extends ClientResourceFileDeserializer {
    public CycleQuestInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CycleQuestSituationInfo readCycleQuestSituationInfo(FileReader fileReader) {
        return new CycleQuestSituationInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static CycleQuestInfo readCycleQuestInfo(FileReader fileReader) {
        return new CycleQuestInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(CycleQuestInfoDeserializer::readCycleQuestSituationInfo),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected CycleQuestInfoList parseClientResourceFile(FileReader fileReader) {
        return new CycleQuestInfoList(fileReader.readArray(CycleQuestInfoDeserializer::readCycleQuestInfo));
    }
}
