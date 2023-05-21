package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season2.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season2.base.LandAreaInfo;

import java.util.List;

public class LandInfoDeserializer extends ClientResourceFileDeserializer<List<LandAreaInfo>> {
    public LandInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static LandAreaInfo readEntity(FileReader fileReader) {
        return new LandAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected List<LandAreaInfo> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(LandInfoDeserializer::readEntity);
    }
}
