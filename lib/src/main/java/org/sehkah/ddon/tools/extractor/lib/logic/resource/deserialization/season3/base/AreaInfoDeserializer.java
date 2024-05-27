package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.AreaInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.AreaInfoList;

import java.util.List;

public class AreaInfoDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.AreaInfo readAreaInfoSeason1(BufferReader bufferReader) {
        return new org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.AreaInfo(
                bufferReader.readUnsignedInteger()
        );
    }

    private static AreaInfo readAreaInfo(BufferReader bufferReader) {
        return new AreaInfo(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readSignedInteger()
        );
    }

    @Override
    protected AreaInfoList parseClientResourceFile(BufferReader bufferReader) {
        long length = bufferReader.readUnsignedInteger();
        List<org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.AreaInfo> areaInfos;
        // Season 1 requires special handling as they did not adjust the version we have no way of knowing this any other way right now
        if (length < 10) {
            areaInfos = bufferReader.readFixedLengthArray(length, AreaInfoDeserializer::readAreaInfoSeason1);
        } else {
            areaInfos = bufferReader.readFixedLengthArray(length, AreaInfoDeserializer::readAreaInfo);
        }

        return new AreaInfoList(areaInfos);
    }
}
