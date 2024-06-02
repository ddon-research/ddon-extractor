package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.JobTutorialQuestList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.game_common.QuestId;

public class JobTutorialQuestListDeserializer extends ClientResourceFileDeserializer {
    public JobTutorialQuestListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    static QuestId readQuestId(BufferReader bufferReader) {
        return new QuestId(bufferReader.readUnsignedInteger());
    }

    @Override
    protected JobTutorialQuestList parseClientResourceFile(BufferReader bufferReader) {
        return new JobTutorialQuestList(bufferReader.readArray(JobTutorialQuestListDeserializer::readQuestId));
    }
}
