package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.EM;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.ChildRegionStatusParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.EM.ChildRegionStatusParamTable;

public class ChildRegionStatusParamDeserializer extends ClientResourceFileDeserializer {
    public ChildRegionStatusParamDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    protected static ChildRegionStatusParam readChildRegionStatusParam(FileReader fileReader) {
        return new ChildRegionStatusParam(
                fileReader.readUnsignedInteger(),
                fileReader.readFixedLengthArray(2, FileReader::readUnsignedInteger),
                fileReader.readFixedLengthArray(4, FileReader::readFloat),
                fileReader.readFixedLengthArray(7, FileReader::readFloat),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFixedLengthArray(4, FileReader::readFloat),
                fileReader.readFixedLengthArray(7, FileReader::readFloat),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFixedLengthArray(33, FileReader::readFloat),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readBoolean(),
                fileReader.readBoolean(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readVector3f(),
                fileReader.readSignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readFixedLengthArray(4, FileReader::readUnsignedInteger),
                fileReader.readFixedLengthArray(6, FileReader::readBoolean)
        );
    }

    @Override
    protected ChildRegionStatusParamTable parseClientResourceFile(FileReader fileReader) {
        return new ChildRegionStatusParamTable(fileReader.readArray(ChildRegionStatusParamDeserializer::readChildRegionStatusParam));
    }
}
