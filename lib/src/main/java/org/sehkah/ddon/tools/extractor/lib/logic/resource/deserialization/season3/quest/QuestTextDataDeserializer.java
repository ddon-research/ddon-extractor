package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.QuestTextData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.QuestTextDataList;

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
