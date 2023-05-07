package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.CycleQuestInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.CycleQuestSituationInfo;

public class CycleQuestInfoDeserializer extends FileDeserializer {
    public CycleQuestInfoDeserializer(FileReader fileReader) {
        super(ExtensionMap.rCycleQuestInfo, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(CycleQuestInfoDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
