package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.TutorialQuestGroup;

public class TutorialQuestGroupDeserializer extends FileDeserializer {
    public TutorialQuestGroupDeserializer(FileReader fileReader) {
        super(ExtensionMap.rTutorialQuestGroup, fileReader);
    }

    private static TutorialQuestGroup readEntity(FileReader fileReader) {
        return new TutorialQuestGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(JobTutorialQuestListDeserializer::readEntity)
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(TutorialQuestGroupDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
