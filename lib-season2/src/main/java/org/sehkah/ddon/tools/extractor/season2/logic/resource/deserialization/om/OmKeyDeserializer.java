package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.om;

import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.binary.XfsDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.om.OmKey;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.om.OmKeyItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.om.OmKeyOmKey;

import java.nio.file.Path;

public class OmKeyDeserializer extends ClientResourceFileDeserializer<OmKey> {


    private static OmKeyItem readOmKeyItem(BufferReader bufferReader) {
        int index1 = bufferReader.readUnsignedShort();
        int propertyIndex = bufferReader.readUnsignedShort();
        long bufferSize = bufferReader.readUnsignedInteger();

        long propertyCount1 = bufferReader.readUnsignedInteger();
        int ItemIndex = bufferReader.readSignedInteger();

        long propertyCount2 = bufferReader.readUnsignedInteger();
        long Color = bufferReader.readUnsignedInteger();

        return new OmKeyItem(
                ItemIndex,
                Color
        );
    }

    private static OmKeyOmKey readOmKeyOmKey(BufferReader bufferReader) {
        int index1 = bufferReader.readUnsignedShort();
        int propertyIndex = bufferReader.readUnsignedShort();
        long bufferSize = bufferReader.readUnsignedInteger();

        long propertyCount1 = bufferReader.readUnsignedInteger();
        int OmID = bufferReader.readSignedInteger();

        long propertyCount2 = bufferReader.readUnsignedInteger();
        long KeyType = bufferReader.readUnsignedInteger();

        long propertyCount3 = bufferReader.readUnsignedInteger();
        Vector3f Pos = bufferReader.readVector3f();
        float pad = bufferReader.readFloat();

        long propertyCount4 = bufferReader.readUnsignedInteger();
        boolean Horizontal = bufferReader.readBoolean();

        return new OmKeyOmKey(
                OmID,
                KeyType,
                Pos,
                Horizontal
        );
    }

    @Override
    protected OmKey parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        // Account for hacky workaround to make a unique resourceVersion by reading in both the deserializer and class resourceVersion initially
        bufferReader.setPosition(bufferReader.getPosition() - 2);

        XfsDeserializer.readHeader(bufferReader);
        XfsDeserializer.readResource(bufferReader);

        return new OmKey(
                XfsDeserializer.readMtArray(bufferReader, OmKeyDeserializer::readOmKeyOmKey),
                XfsDeserializer.readMtArray(bufferReader, OmKeyDeserializer::readOmKeyItem)
        );
    }
}
