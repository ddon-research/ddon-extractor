package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandAreaInfo;

import java.util.List;

public class LandInfoDeserializer extends FileDeserializer<List<LandAreaInfo>> {
    public LandInfoDeserializer() {
        super(ClientResourceFile.rLandInfo);
    }

    private static LandAreaInfo readEntity(FileReader fileReader) {
        return new LandAreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedByte(),
                fileReader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    protected List<LandAreaInfo> readObject(FileReader fileReader) {
        return fileReader.readArray(LandInfoDeserializer::readEntity);
    }
}
