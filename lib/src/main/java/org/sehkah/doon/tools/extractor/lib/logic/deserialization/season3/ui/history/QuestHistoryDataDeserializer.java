package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.ui.history;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.ui.history.QuestHistoryData;

import java.util.List;

public class QuestHistoryDataDeserializer extends ClientResourceFileDeserializer<List<QuestHistoryData>> {
    public QuestHistoryDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestHistoryData readEntity(FileReader fileReader) {
        return new QuestHistoryData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected List<QuestHistoryData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(QuestHistoryDataDeserializer::readEntity);
    }
}
