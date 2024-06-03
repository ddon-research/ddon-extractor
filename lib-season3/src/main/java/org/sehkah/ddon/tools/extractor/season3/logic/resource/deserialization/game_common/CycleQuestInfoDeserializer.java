package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleQuestInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleQuestInfoList;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.game_common.CycleQuestSituationInfo;

public class CycleQuestInfoDeserializer extends ClientResourceFileDeserializer {
    public CycleQuestInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static CycleQuestSituationInfo readCycleQuestSituationInfo(BufferReader bufferReader) {
        return new CycleQuestSituationInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static CycleQuestInfo readCycleQuestInfo(BufferReader bufferReader) {
        return new CycleQuestInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(CycleQuestInfoDeserializer::readCycleQuestSituationInfo),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected CycleQuestInfoList parseClientResourceFile(BufferReader bufferReader) {
        return new CycleQuestInfoList(bufferReader.readArray(CycleQuestInfoDeserializer::readCycleQuestInfo));
    }
}
