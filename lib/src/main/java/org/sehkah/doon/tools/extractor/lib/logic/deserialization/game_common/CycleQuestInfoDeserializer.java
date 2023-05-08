package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.CycleQuestInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.CycleQuestSituationInfo;

import java.util.List;

public class CycleQuestInfoDeserializer extends FileDeserializer<List<CycleQuestInfo>> {
    public CycleQuestInfoDeserializer() {
        super(ClientResourceFile.rCycleQuestInfo);
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
    protected List<CycleQuestInfo> readObject(FileReader fileReader) {
        return fileReader.readArray(CycleQuestInfoDeserializer::readEntity);
    }
}
