package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.QuestTextData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest.QuestTextDataList;

public class QuestTextDataDeserializer extends ClientResourceFileDeserializer {
    public QuestTextDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestTextData readQuestTextData(BufferReader bufferReader) {
        return new QuestTextData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected QuestTextDataList parseClientResourceFile(BufferReader bufferReader) {
        return new QuestTextDataList(bufferReader.readArray(QuestTextDataDeserializer::readQuestTextData));
    }
}
