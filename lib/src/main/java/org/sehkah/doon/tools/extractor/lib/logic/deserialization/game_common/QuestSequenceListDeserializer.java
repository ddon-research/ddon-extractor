package org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.game_common.QuestSequence;

public class QuestSequenceListDeserializer extends FileDeserializer {
    public QuestSequenceListDeserializer() {
        super(ClientResourceFile.rQuestSequenceList);
    }

    private static QuestSequence readEntity(FileReader fileReader) {
        return new QuestSequence(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(QuestSequenceListDeserializer::readEntity);
    }
}
