package org.sehkah.doon.tools.extractor.lib.logic.deserialization.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.QuestMarkerInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.QuestMarkerInfoInfo;

public class QuestMarkerInfoDeserializer extends FileDeserializer {
    public QuestMarkerInfoDeserializer() {
        super(ClientResourceFile.rQuestMarkerInfo);
    }

    private static QuestMarkerInfoInfo readQuestMarkerInfoInfo(FileReader fileReader) {
        return new QuestMarkerInfoInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readVector3f()
        );
    }

    private static QuestMarkerInfo readEntity(FileReader fileReader) {
        return new QuestMarkerInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(QuestMarkerInfoDeserializer::readQuestMarkerInfoInfo)
        );
    }

    @Override
    protected Object readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
