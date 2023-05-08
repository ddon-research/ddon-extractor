package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.history;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.history.QuestHistoryData;

public class QuestHistoryDataDeserializer extends FileDeserializer {
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
    protected Object readObject(FileReader fileReader) {
        return fileReader.readArray(QuestHistoryDataDeserializer::readEntity);
    }
}
