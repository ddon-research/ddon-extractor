package org.sehkah.doon.tools.extractor.lib.logic.deserialization.quest;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.quest.TalkData;

import java.util.List;

public class PawnQuestTalkDeserializer extends FileDeserializer<List<TalkData>> {
    public PawnQuestTalkDeserializer() {
        super(ClientResourceFile.rPawnQuestTalk);
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
    protected List<TalkData> readObject(FileReader fileReader) {
        return fileReader.readArray(PawnQuestTalkDeserializer::readEntity);
    }
}
