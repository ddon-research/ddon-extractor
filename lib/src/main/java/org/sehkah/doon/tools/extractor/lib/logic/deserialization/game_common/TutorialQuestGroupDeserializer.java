package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.TutorialQuestGroup;

import java.util.List;

public class TutorialQuestGroupDeserializer extends FileDeserializer<List<TutorialQuestGroup>> {
    public TutorialQuestGroupDeserializer() {
        super(ClientResourceFile.rTutorialQuestGroup);
    }

    private static TutorialQuestGroup readEntity(FileReader fileReader) {
        return new TutorialQuestGroup(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(JobTutorialQuestListDeserializer::readEntity)
        );
    }

    @Override
    protected List<TutorialQuestGroup> readObject(FileReader fileReader) {
        return fileReader.readArray(TutorialQuestGroupDeserializer::readEntity);
    }
}
