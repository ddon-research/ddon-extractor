package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.fieldarea.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.fieldarea.AdjoinInfoVector3;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.fieldarea.FieldAreaAdjoinList;

public class FieldAreaAdjoinListDeserializer extends ClientResourceFileDeserializer {
    public FieldAreaAdjoinListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdjoinInfoVector3 readAdjoinInfoVector3(FileReader fileReader) {
        return new AdjoinInfoVector3(
                fileReader.readVector3f(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static AdjoinInfo readAdjoinInfo(FileReader fileReader) {
        return new AdjoinInfo(
                fileReader.readSignedShort(),
                fileReader.readSignedShort(),
                fileReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfoVector3),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected FieldAreaAdjoinList parseClientResourceFile(FileReader fileReader) {
        return new FieldAreaAdjoinList(
                fileReader.readSignedShort(),
                fileReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfo)
        );
    }
}
