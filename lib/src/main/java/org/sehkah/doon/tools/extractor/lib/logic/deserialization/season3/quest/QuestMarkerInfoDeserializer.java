package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.QuestMarkerInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.QuestMarkerInfoInfo;

public class QuestMarkerInfoDeserializer extends ClientResourceFileDeserializer {

    public QuestMarkerInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static QuestMarkerInfoInfo readQuestMarkerInfoInfo(FileReader fileReader) {
        return new QuestMarkerInfoInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readVector3f()
        );
    }

    @Override
    protected QuestMarkerInfo parseClientResourceFile(FileReader fileReader) {
        return new QuestMarkerInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(QuestMarkerInfoDeserializer::readQuestMarkerInfoInfo)
        );
    }
}
