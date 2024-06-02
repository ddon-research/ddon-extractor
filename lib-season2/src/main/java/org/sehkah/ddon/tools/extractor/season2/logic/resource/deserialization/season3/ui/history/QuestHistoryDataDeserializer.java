package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.ui.history;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.ui.history.QuestHistoryData;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.ui.history.QuestHistoryDataList;

public class QuestHistoryDataDeserializer extends ClientResourceFileDeserializer {
    public QuestHistoryDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestHistoryData readQuestHistoryData(BufferReader bufferReader) {
        return new QuestHistoryData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected QuestHistoryDataList parseClientResourceFile(BufferReader bufferReader) {
        return new QuestHistoryDataList(bufferReader.readArray(QuestHistoryDataDeserializer::readQuestHistoryData));
    }
}
