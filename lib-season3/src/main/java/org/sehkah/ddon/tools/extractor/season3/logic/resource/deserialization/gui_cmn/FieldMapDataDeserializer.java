package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn.FieldMapData;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.gui_cmn.FieldMapDataList;

import java.nio.file.Path;

public class FieldMapDataDeserializer extends ClientResourceFileDeserializer<FieldMapDataList> {


    private static FieldMapData readFieldMapData(BufferReader bufferReader) {
        return new FieldMapData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readFloat2f(),
                bufferReader.readVector3f(),
                bufferReader.readBoolean(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected FieldMapDataList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new FieldMapDataList(bufferReader.readArray(FieldMapDataDeserializer::readFieldMapData));
    }
}
