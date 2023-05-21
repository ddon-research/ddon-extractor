package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.QuestId;

import java.util.List;

public class JobTutorialQuestListDeserializer extends ClientResourceFileDeserializer<List<QuestId>> {
    public JobTutorialQuestListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    static QuestId readEntity(FileReader fileReader) {
        return new QuestId(fileReader.readUnsignedInteger());
    }

    @Override
    protected List<QuestId> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(JobTutorialQuestListDeserializer::readEntity);
    }
}
