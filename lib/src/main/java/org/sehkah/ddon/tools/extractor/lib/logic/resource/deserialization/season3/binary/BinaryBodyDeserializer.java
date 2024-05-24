package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.binary;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.BinaryBody;

import java.util.List;
import java.util.function.Function;

public class BinaryBodyDeserializer {
    public static BinaryBody parseBody(BufferReader bufferReader) {
        long index = bufferReader.readUnsignedInteger();

        long bufferSizeForBody = bufferReader.readUnsignedInteger();

        long propertyCount1 = bufferReader.readUnsignedInteger();
        long quality = bufferReader.readUnsignedInteger();

        return new BinaryBody(
                index,
                bufferSizeForBody,
                propertyCount1,
                quality
        );
    }

    public static <T> List<T> parseBinaryList(BufferReader bufferReader, Function<BufferReader, T> entityReaderFunction) {
        long propertyCount2 = bufferReader.readUnsignedInteger();
        int index1 = bufferReader.readUnsignedShort();
        int propertyIndex = bufferReader.readUnsignedShort();
        long bufferSize2 = bufferReader.readUnsignedInteger();

        long propertyCount3 = bufferReader.readUnsignedInteger();
        boolean autoDelete = bufferReader.readBoolean();
        long length = bufferReader.readUnsignedInteger();
        List<T> Data = bufferReader.readFixedLengthArray(length, entityReaderFunction);
        return Data;
    }
}
