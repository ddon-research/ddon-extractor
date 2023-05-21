package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.JobTutorialQuestList;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.QuestId;

public class JobTutorialQuestListDeserializer extends ClientResourceFileDeserializer {
    public JobTutorialQuestListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    static QuestId readQuestId(FileReader fileReader) {
        return new QuestId(fileReader.readUnsignedInteger());
    }

    @Override
    protected JobTutorialQuestList parseClientResourceFile(FileReader fileReader) {
        return new JobTutorialQuestList(fileReader.readArray(JobTutorialQuestListDeserializer::readQuestId));
    }
}
