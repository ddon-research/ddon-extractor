package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.QuestTextData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.QuestTextDataList;

public class QuestTextDataDeserializer extends ClientResourceFileDeserializer {
    public QuestTextDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestTextData readQuestTextData(FileReader fileReader) {
        return new QuestTextData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestTextDataList parseClientResourceFile(FileReader fileReader) {
        return new QuestTextDataList(fileReader.readArray(QuestTextDataDeserializer::readQuestTextData));
    }
}
