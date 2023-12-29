package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.binary.BinaryHeaderDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.TexDetailEdit;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.TexDetailEditParam;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.binary.TexDetailEditBinaryBody;

import java.util.List;

public class TexDetailEditDeserializer extends ClientResourceFileDeserializer {
    public TexDetailEditDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TexDetailEditParam readTexDetailEditParam(FileReader fileReader) {
        return new TexDetailEditParam(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readNullTerminatedString(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    private static TexDetailEditBinaryBody readTexDetailEditBinaryBody(FileReader fileReader) {
        long count1 = fileReader.readUnsignedInteger();
        long bufferSize1 = fileReader.readUnsignedInteger();
        long unknown1 = fileReader.readUnsignedInteger();
        long unknown2 = fileReader.readUnsignedInteger();
        long unknown3 = fileReader.readUnsignedInteger();
        int index1 = fileReader.readUnsignedShort();
        int index2 = fileReader.readUnsignedShort();
        long bufferSize2 = fileReader.readUnsignedInteger();
        long count2 = fileReader.readUnsignedInteger();
        boolean autoDelete = fileReader.readBoolean();
        long length = fileReader.readUnsignedInteger();
        List<TexDetailEditParam> EditList = fileReader.readFixedLengthArray(length, TexDetailEditDeserializer::readTexDetailEditParam);

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
    protected TexDetailEdit parseClientResourceFile(FileReader fileReader) {
        // Account for hacky workaround to make a unique version by reading in both the deserializer and class version initially
        fileReader.setPosition(fileReader.getPosition() - 2);
        return new TexDetailEdit(
                BinaryHeaderDeserializer.parseClientResourceFile(fileReader),
                readTexDetailEditBinaryBody(fileReader)
        );
    }
}
