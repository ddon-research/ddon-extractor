package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.binary.BinaryBodyDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.binary.BinaryHeaderDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.TexDetailEdit;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.TexDetailEditParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.BinaryBody;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.BinaryHeader;

public class TexDetailEditDeserializer extends ClientResourceFileDeserializer {
    public TexDetailEditDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TexDetailEditParam readTexDetailEditParam(BufferReader bufferReader) {
        int index1 = bufferReader.readUnsignedShort();
        int propertyIndex = bufferReader.readUnsignedShort();
        long bufferSize = bufferReader.readUnsignedInteger();

        long propertyCount1 = bufferReader.readUnsignedInteger();
        String Path = bufferReader.readNullTerminatedString();
        long propertyCount2 = bufferReader.readUnsignedInteger();
        long Form = bufferReader.readUnsignedInteger();
        long propertyCount3 = bufferReader.readUnsignedInteger();
        long Type = bufferReader.readUnsignedInteger();

        return new TexDetailEditParam(
                Path,
                Form,
                Type
        );
    }

    @Override
    protected TexDetailEdit parseClientResourceFile(BufferReader bufferReader) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        BinaryHeader binaryHeader = BinaryHeaderDeserializer.parseHeader(bufferReader);
        BinaryBody binaryBody = BinaryBodyDeserializer.parseBody(bufferReader);

        return new TexDetailEdit(
                BinaryBodyDeserializer.parseBinaryList(bufferReader, TexDetailEditDeserializer::readTexDetailEditParam)
        );
    }
}
