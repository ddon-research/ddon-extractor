package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.quest.TalkData;

import java.util.List;

public class PawnQuestTalkDeserializer extends ClientResourceFileDeserializer<List<TalkData>> {

    public PawnQuestTalkDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TalkData readEntity(FileReader fileReader) {
        return new TalkData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<TalkData> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(PawnQuestTalkDeserializer::readEntity);
    }
}
