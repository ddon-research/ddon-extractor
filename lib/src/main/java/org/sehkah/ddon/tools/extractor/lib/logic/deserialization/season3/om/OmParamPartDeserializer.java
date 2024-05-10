package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.om;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.om.OmParamPart;

public class OmParamPartDeserializer extends ClientResourceFileDeserializer {

    public OmParamPartDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static OmParamPart readOmParamPart(FileReader fileReader) {
        return new OmParamPart(
                fileReader.readSignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readUnsignedLong(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readVector3f(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readVector3f(),
                fileReader.readBoolean(),
                fileReader.readVector3f(),
                fileReader.readVector3f(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(4, FileReader::readUnsignedLong),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected OmParamPart parseClientResourceFile(FileReader fileReader) {
        return readOmParamPart(fileReader);
    }
}
