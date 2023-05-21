package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.QuestSequence;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.game_common.QuestSequenceList;

public class QuestSequenceListDeserializer extends ClientResourceFileDeserializer {
    public QuestSequenceListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestSequence readQuestSequence(FileReader fileReader) {
        return new QuestSequence(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestSequenceList parseClientResourceFile(FileReader fileReader) {
        return new QuestSequenceList(fileReader.readArray(QuestSequenceListDeserializer::readQuestSequence));
    }
}
