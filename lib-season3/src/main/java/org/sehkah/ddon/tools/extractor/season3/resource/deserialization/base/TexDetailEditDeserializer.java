package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.deserialization.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.TexDetailEdit;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.TexDetailEditParam;

public class TexDetailEditDeserializer extends ClientResourceFileDeserializer {
    public TexDetailEditDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static TexDetailEditParam readTexDetailEditParam(BufferReader bufferReader) {
        XfsDeserializer.readXfsObjectData(bufferReader);

        String Path = XfsDeserializer.readNullTerminatedString(bufferReader);
        long Form = XfsDeserializer.readUnsignedInteger(bufferReader);
        long Type = XfsDeserializer.readUnsignedInteger(bufferReader);

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

        XfsDeserializer.readHeader(bufferReader);
        XfsDeserializer.readResource(bufferReader);

        return new TexDetailEdit(
                XfsDeserializer.readMtArray(bufferReader, TexDetailEditDeserializer::readTexDetailEditParam)
        );
    }
}
