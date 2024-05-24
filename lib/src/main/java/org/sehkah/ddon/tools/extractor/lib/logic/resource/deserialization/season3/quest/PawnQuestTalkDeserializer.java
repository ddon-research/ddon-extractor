package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.quest;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.PawnQuestTalk;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.quest.TalkData;

public class PawnQuestTalkDeserializer extends ClientResourceFileDeserializer {

    public PawnQuestTalkDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TalkData readTalkData(BufferReader bufferReader) {
        return new TalkData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected PawnQuestTalk parseClientResourceFile(BufferReader bufferReader) {
        return new PawnQuestTalk(bufferReader.readArray(PawnQuestTalkDeserializer::readTalkData));
    }
}
