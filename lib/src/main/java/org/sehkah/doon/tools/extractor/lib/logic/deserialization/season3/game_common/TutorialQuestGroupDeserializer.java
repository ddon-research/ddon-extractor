package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.TutorialQuestGroup;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.TutorialQuestGroupList;

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
