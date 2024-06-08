package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.StartPosArea;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.gui_cmn.StartPosAreaList;

import java.nio.file.Path;

public class StartPosAreaDeserializer extends ClientResourceFileDeserializer<StartPosAreaList> {


    private static StartPosArea readStartPosArea(BufferReader bufferReader) {
        return new StartPosArea(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected StartPosAreaList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StartPosAreaList(bufferReader.readArray(StartPosAreaDeserializer::readStartPosArea));
    }
}
