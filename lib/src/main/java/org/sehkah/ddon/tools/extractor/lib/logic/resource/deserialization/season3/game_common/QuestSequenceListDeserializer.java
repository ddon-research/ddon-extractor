package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.QuestSequence;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.game_common.QuestSequenceList;

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
