package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.quest;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.PawnQuestTalk;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest.TalkData;

public class PawnQuestTalkDeserializer extends ClientResourceFileDeserializer<PawnQuestTalk> {


    private static TalkData readTalkData(BufferReader bufferReader) {
        return new TalkData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected PawnQuestTalk parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new PawnQuestTalk(bufferReader.readArray(PawnQuestTalkDeserializer::readTalkData));
    }
}
