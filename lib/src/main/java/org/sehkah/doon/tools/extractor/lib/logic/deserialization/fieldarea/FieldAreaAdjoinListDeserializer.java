package org.sehkah.doon.tools.extractor.lib.logic.deserialization.fieldarea;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.AdjoinInfo;
import org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.AdjoinInfoVector3;
import org.sehkah.doon.tools.extractor.lib.logic.entity.fieldarea.FieldAreaAdjoinList;

public class FieldAreaAdjoinListDeserializer extends FileDeserializer<FieldAreaAdjoinList> {
    public FieldAreaAdjoinListDeserializer() {
        super(ClientResourceFile.rFieldAreaAdjoinList);
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

    private static FieldAreaAdjoinList readEntity(FileReader fileReader) {
        return new FieldAreaAdjoinList(
                fileReader.readSignedShort(),
                fileReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfo)
        );
    }

    @Override
    protected FieldAreaAdjoinList readObject(FileReader fileReader) {
        return readEntity(fileReader);
    }
}
