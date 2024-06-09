package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.WarpLocation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.WarpLocationList;

import java.nio.file.Path;

public class WarpLocationDeserializer extends ClientResourceFileDeserializer<WarpLocationList> {


    private static WarpLocation readWarpLocation(BufferReader bufferReader) {
        return new WarpLocation(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected WarpLocationList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new WarpLocationList(bufferReader.readArray(WarpLocationDeserializer::readWarpLocation));
    }
}
