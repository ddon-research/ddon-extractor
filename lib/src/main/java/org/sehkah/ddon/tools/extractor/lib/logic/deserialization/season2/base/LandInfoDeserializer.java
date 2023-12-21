package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season2.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.LandAreaInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season2.base.LandAreaInfoList;

public class LandInfoDeserializer extends ClientResourceFileDeserializer {
    public LandInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LandAreaInfo readLandAreaInfo(FileReader fileReader) {
        return new LandAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected LandAreaInfoList parseClientResourceFile(FileReader fileReader) {
        return new LandAreaInfoList(fileReader.readArray(LandInfoDeserializer::readLandAreaInfo));
    }
}
