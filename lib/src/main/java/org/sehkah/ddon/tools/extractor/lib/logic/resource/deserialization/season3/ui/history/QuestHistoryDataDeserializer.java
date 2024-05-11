package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.history;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.history.QuestHistoryData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.history.QuestHistoryDataList;

public class QuestHistoryDataDeserializer extends ClientResourceFileDeserializer {
    public QuestHistoryDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestHistoryData readQuestHistoryData(FileReader fileReader) {
        return new QuestHistoryData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected QuestHistoryDataList parseClientResourceFile(FileReader fileReader) {
        return new QuestHistoryDataList(fileReader.readArray(QuestHistoryDataDeserializer::readQuestHistoryData));
    }
}
