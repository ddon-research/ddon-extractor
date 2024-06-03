package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.fieldarea;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.AdjoinInfo;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.AdjoinInfoVector3;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.fieldarea.FieldAreaAdjoinList;

public class FieldAreaAdjoinListDeserializer extends ClientResourceFileDeserializer {
    public FieldAreaAdjoinListDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AdjoinInfoVector3 readAdjoinInfoVector3(BufferReader bufferReader) {
        return new AdjoinInfoVector3(
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static AdjoinInfo readAdjoinInfo(BufferReader bufferReader) {
        return new AdjoinInfo(
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfoVector3),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected FieldAreaAdjoinList parseClientResourceFile(BufferReader bufferReader) {
        return new FieldAreaAdjoinList(
                bufferReader.readSignedShort(),
                bufferReader.readArray(FieldAreaAdjoinListDeserializer::readAdjoinInfo)
        );
    }
}
