package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.TexDetailEdit;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.base.TexDetailEditParam;

import java.nio.file.Path;

public class TexDetailEditDeserializer extends ClientResourceFileDeserializer<TexDetailEdit> {


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
    protected TexDetailEdit parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        XfsDeserializer.readHeader(bufferReader);
        XfsDeserializer.readResource(bufferReader);

        return new TexDetailEdit(
                XfsDeserializer.readMtArray(bufferReader, TexDetailEditDeserializer::readTexDetailEditParam)
        );
    }
}
