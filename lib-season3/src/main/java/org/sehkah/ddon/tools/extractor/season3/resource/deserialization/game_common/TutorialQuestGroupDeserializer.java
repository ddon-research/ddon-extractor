package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.TutorialQuestGroup;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.game_common.TutorialQuestGroupList;

public class TutorialQuestGroupDeserializer extends ClientResourceFileDeserializer {
    public TutorialQuestGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TutorialQuestGroup readTutorialQuestGroup(BufferReader bufferReader) {
        return new TutorialQuestGroup(
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(JobTutorialQuestListDeserializer::readQuestId)
        );
    }

    @Override
    protected TutorialQuestGroupList parseClientResourceFile(BufferReader bufferReader) {
        return new TutorialQuestGroupList(bufferReader.readArray(TutorialQuestGroupDeserializer::readTutorialQuestGroup));
    }
}
