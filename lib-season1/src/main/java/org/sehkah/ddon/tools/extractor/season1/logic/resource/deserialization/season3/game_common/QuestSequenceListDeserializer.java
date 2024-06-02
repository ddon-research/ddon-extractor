package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.QuestSequence;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.game_common.QuestSequenceList;

public class QuestSequenceListDeserializer extends ClientResourceFileDeserializer {
    public QuestSequenceListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestSequence readQuestSequence(BufferReader bufferReader) {
        return new QuestSequence(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestSequenceList parseClientResourceFile(BufferReader bufferReader) {
        return new QuestSequenceList(bufferReader.readArray(QuestSequenceListDeserializer::readQuestSequence));
    }
}
