package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.AreaInfo;

import java.util.List;

public class AreaInfoDeserializer extends ClientResourceFileDeserializer<List<AreaInfo>> {
    public AreaInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfo readEntity(FileReader fileReader) {
        return new AreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected List<AreaInfo> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(AreaInfoDeserializer::readEntity);
    }
}
