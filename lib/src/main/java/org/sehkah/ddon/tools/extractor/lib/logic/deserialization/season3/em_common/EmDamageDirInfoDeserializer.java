package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.em_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.em_common.EmDamageDirInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.em_common.EmDamageDirInfoList;

public class EmDamageDirInfoDeserializer extends ClientResourceFileDeserializer {
    public EmDamageDirInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static EmDamageDirInfo readEmDamageDirInfo(FileReader fileReader) {
        return new EmDamageDirInfo(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected EmDamageDirInfoList parseClientResourceFile(FileReader fileReader) {
        return new EmDamageDirInfoList(fileReader.readArray(EmDamageDirInfoDeserializer::readEmDamageDirInfo));
    }
}
