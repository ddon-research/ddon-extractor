package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.StageListInfoList;

import java.util.ArrayList;
import java.util.List;

public class StageListDeserializer extends ClientResourceFileDeserializer {
    public StageListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageListInfo readStageListInfo(BufferReader bufferReader) {
        return new StageListInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageListInfoList parseClientResourceFile(BufferReader bufferReader) {
        long stageListInfoSize = bufferReader.readUnsignedInteger();
        List<StageListInfo> stageListInfo = new ArrayList<>((int) stageListInfoSize);
        for (long i = 0; i < stageListInfoSize; i++) {
            stageListInfo.add(readStageListInfo(bufferReader));
        }
        return new StageListInfoList(
                stageListInfoSize,
                stageListInfo
        );
    }
}
