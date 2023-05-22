package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.AreaInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.AreaInfoList;

public class AreaInfoDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfo readAreaInfo(FileReader fileReader) {
        return new AreaInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger()
        );
    }

    @Override
    protected AreaInfoList parseClientResourceFile(FileReader fileReader) {
        return new AreaInfoList(fileReader.readArray(AreaInfoDeserializer::readAreaInfo));
    }
}
