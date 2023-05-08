package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.history;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.history.QuestHistoryData;

import java.util.List;

public class QuestHistoryDataDeserializer extends FileDeserializer<List<QuestHistoryData>> {
    public QuestHistoryDataDeserializer() {
        super(ClientResourceFile.rQuestHistoryData);
    }

    private static QuestHistoryData readEntity(FileReader fileReader) {
        return new QuestHistoryData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort()
        );
    }

    @Override
    protected List<QuestHistoryData> readObject(FileReader fileReader) {
        return fileReader.readArray(QuestHistoryDataDeserializer::readEntity);
    }
}
