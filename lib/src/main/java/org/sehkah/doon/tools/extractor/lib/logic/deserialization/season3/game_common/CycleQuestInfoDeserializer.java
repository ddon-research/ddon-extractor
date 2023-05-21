package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.CycleQuestInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.CycleQuestSituationInfo;

import java.util.List;

public class CycleQuestInfoDeserializer extends ClientResourceFileDeserializer<List<CycleQuestInfo>> {
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

    private static CycleQuestInfo readEntity(FileReader fileReader) {
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
    protected List<CycleQuestInfo> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(CycleQuestInfoDeserializer::readEntity);
    }
}
