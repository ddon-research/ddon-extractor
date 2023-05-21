package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.QuestTextData;

import java.util.List;

public class QuestTextDataDeserializer extends ClientResourceFileDeserializer<List<QuestTextData>> {
    public QuestTextDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestTextData readEntity(FileReader fileReader) {
        return new QuestTextData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<QuestTextData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(QuestTextDataDeserializer::readEntity);
    }
}
