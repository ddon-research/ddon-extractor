package org.sehkah.ddon.tools.extractor.common.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.StageMap;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.StageMapList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.gui_cmn.StageMapParam;

import java.nio.file.Path;

public class StageMapDeserializer extends ClientResourceFileDeserializer<StageMapList> {
    private static StageMapParam readParam(BufferReader reader) {
        return new StageMapParam(
                reader.readUnsignedInteger(),
                reader.readFloat(),
                reader.readNullTerminatedString(),
                reader.readVector3f()
        );
    }

    private static StageMap readStageMap(BufferReader bufferReader) {
        return new StageMap(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readArray(StageMapDeserializer::readParam)
        );
    }

    @Override
    protected StageMapList parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageMapList(bufferReader.readArray(StageMapDeserializer::readStageMap));
    }
}
