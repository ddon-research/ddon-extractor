package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.AreaInfo;

import java.util.List;

public class AreaInfoDeserializer extends FileDeserializer<List<AreaInfo>> {
    public AreaInfoDeserializer() {
        super(ClientResourceFile.rAreaInfo);
    }

    private static AreaInfo readEntity(FileReader fileReader) {
        return new AreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected List<AreaInfo> readObject(FileReader fileReader) {
        return fileReader.readArray(AreaInfoDeserializer::readEntity);
    }
}
