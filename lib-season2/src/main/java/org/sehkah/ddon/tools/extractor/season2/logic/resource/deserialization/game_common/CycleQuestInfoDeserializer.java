package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.game_common;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CycleQuestInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CycleQuestInfoList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common.CycleQuestSituationInfo;

import java.nio.file.Path;

public class CycleQuestInfoDeserializer extends ClientResourceFileDeserializer<CycleQuestInfoList> {


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
    protected CycleQuestInfoList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new CycleQuestInfoList(bufferReader.readArray(CycleQuestInfoDeserializer::readCycleQuestInfo));
    }
}
