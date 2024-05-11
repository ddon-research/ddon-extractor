package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.TutorialQuestGroup;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.TutorialQuestGroupList;

public class TutorialQuestGroupDeserializer extends ClientResourceFileDeserializer {
    public TutorialQuestGroupDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TutorialQuestGroup readTutorialQuestGroup(FileReader fileReader) {
        return new TutorialQuestGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(JobTutorialQuestListDeserializer::readQuestId)
        );
    }

    @Override
    protected TutorialQuestGroupList parseClientResourceFile(FileReader fileReader) {
        return new TutorialQuestGroupList(fileReader.readArray(TutorialQuestGroupDeserializer::readTutorialQuestGroup));
    }
}
