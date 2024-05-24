package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.binary.BinaryHeaderDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.TexDetailEdit;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.TexDetailEditParam;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.binary.TexDetailEditBinaryBody;

import java.util.List;

public class TexDetailEditDeserializer extends ClientResourceFileDeserializer {
    public TexDetailEditDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TexDetailEditParam readTexDetailEditParam(BufferReader bufferReader) {
        return new TexDetailEditParam(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    private static TexDetailEditBinaryBody readTexDetailEditBinaryBody(BufferReader bufferReader) {
        long count1 = bufferReader.readUnsignedInteger();
        long bufferSize1 = bufferReader.readUnsignedInteger();
        long unknown1 = bufferReader.readUnsignedInteger();
        long unknown2 = bufferReader.readUnsignedInteger();
        long unknown3 = bufferReader.readUnsignedInteger();
        int index1 = bufferReader.readUnsignedShort();
        int index2 = bufferReader.readUnsignedShort();
        long bufferSize2 = bufferReader.readUnsignedInteger();
        long count2 = bufferReader.readUnsignedInteger();
        boolean autoDelete = bufferReader.readBoolean();
        long length = bufferReader.readUnsignedInteger();
        List<TexDetailEditParam> EditList = bufferReader.readFixedLengthArray(length, TexDetailEditDeserializer::readTexDetailEditParam);

        return new TexDetailEditBinaryBody(
                count1,
                bufferSize1,
                unknown1,
                unknown2,
                unknown3,
                index1,
                index2,
                bufferSize2,
                count2,
                autoDelete,
                length,
                EditList
        );
    }

    @Override
    protected TexDetailEdit parseClientResourceFile(BufferReader bufferReader) {
        // Account for hacky workaround to make a unique version by reading in both the deserializer and class version initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);
        return new TexDetailEdit(
                BinaryHeaderDeserializer.parseClientResourceFile(bufferReader),
                readTexDetailEditBinaryBody(bufferReader)
        );
    }
}
