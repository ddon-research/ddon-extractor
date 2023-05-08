package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.QuestId;

import java.util.List;

public class JobTutorialQuestListDeserializer extends FileDeserializer<List<QuestId>> {
    public JobTutorialQuestListDeserializer() {
        super(ClientResourceFile.rJobTutorialQuestList);
    }

    static QuestId readEntity(FileReader fileReader) {
        return new QuestId(fileReader.readUnsignedInteger());
    }

    @Override
    protected List<QuestId> readObject(FileReader fileReader) {
        return fileReader.readArray(JobTutorialQuestListDeserializer::readEntity);
    }
}
