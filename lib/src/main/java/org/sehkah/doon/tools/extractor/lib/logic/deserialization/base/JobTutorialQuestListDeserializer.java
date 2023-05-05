package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.QuestId;

public class JobTutorialQuestListDeserializer extends FileDeserializer {
    public JobTutorialQuestListDeserializer(FileReader fileReader) {
        super(ExtensionMap.rJobTutorialQuestList, fileReader);
    }

    private static QuestId readEntity(FileReader fileReader) {
        return new QuestId(
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(JobTutorialQuestListDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
