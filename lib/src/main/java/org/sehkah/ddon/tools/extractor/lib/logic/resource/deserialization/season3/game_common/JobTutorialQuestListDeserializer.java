package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.JobTutorialQuestList;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.QuestId;

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
