package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.QuestId;

public class JobTutorialQuestListDeserializer extends FileDeserializer {
    public JobTutorialQuestListDeserializer() {
        super(ClientResourceFile.rJobTutorialQuestList);
    }

    static QuestId readEntity(FileReader fileReader) {
        return new QuestId(
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(JobTutorialQuestListDeserializer::readEntity);
    }
}
