package org.sehkah.doon.tools.extractor.lib.logic.deserialization.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.QuestTextData;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.meta.QuestTextDataWithMetaInformation;

public class QuestTextDataDeserializer extends FileDeserializer {
    public QuestTextDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rQuestTextData, fileReader);
    }

    private static QuestTextData readEntity(FileReader fileReader) {
        return new QuestTextData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static QuestTextDataWithMetaInformation readEntityWithMetaInformation(FileReader fileReader) {
        return new QuestTextDataWithMetaInformation(readEntity(fileReader));
    }

    @Override
    protected Object readObject() {
        return fileReader.readArray(QuestTextDataDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return fileReader.readArray(QuestTextDataDeserializer::readEntityWithMetaInformation);
    }
}
