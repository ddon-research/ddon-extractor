package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.job;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.MagicChantParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.job.MagicChantParamTbl;

public class MagicChantParamTblDeserializer extends ClientResourceFileDeserializer {
    public MagicChantParamTblDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static MagicChantParam readMagicChantParam(FileReader fileReader) {
        return new MagicChantParam(
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readMatrix(),
                fileReader.readMatrix(),
                fileReader.readMatrix(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readFixedLengthArray(10, FileReader::readFloat),
                fileReader.readBoolean(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readFloat()
        );
    }

    @Override
    protected MagicChantParamTbl parseClientResourceFile(FileReader fileReader) {
        return new MagicChantParamTbl(fileReader.readArray(MagicChantParamTblDeserializer::readMagicChantParam));
    }
}
