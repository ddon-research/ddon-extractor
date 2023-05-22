package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.quest.PawnQuestTalk;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.quest.TalkData;

public class PawnQuestTalkDeserializer extends ClientResourceFileDeserializer {

    public PawnQuestTalkDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TalkData readTalkData(FileReader fileReader) {
        return new TalkData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected PawnQuestTalk parseClientResourceFile(FileReader fileReader) {
        return new PawnQuestTalk(fileReader.readArray(PawnQuestTalkDeserializer::readTalkData));
    }
}
