package org.sehkah.doon.tools.extractor.lib.logic.deserialization.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.QuestTextData;

import java.util.List;

public class QuestTextDataDeserializer extends FileDeserializer<List<QuestTextData>> {
    public QuestTextDataDeserializer() {
        super(ClientResourceFile.rQuestTextData);
    }

    private static QuestTextData readEntity(FileReader fileReader) {
        return new QuestTextData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<QuestTextData> readObject(FileReader fileReader) {
        return fileReader.readArray(QuestTextDataDeserializer::readEntity);
    }
}
