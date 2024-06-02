package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.AreaInfo;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.AreaInfoList;

import java.util.List;

public class AreaInfoDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
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
        List<AreaInfo> areaInfos = bufferReader.readArray(AreaInfoDeserializer::readAreaInfo);

        return new AreaInfoList(areaInfos);
    }
}
