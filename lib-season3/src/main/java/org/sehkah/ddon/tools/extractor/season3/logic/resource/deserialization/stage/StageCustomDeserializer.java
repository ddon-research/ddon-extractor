package org.sehkah.ddon.tools.extractor.season3.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.StageCustom;
import org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage.StageCustomArea;

import java.nio.file.Path;

public class StageCustomDeserializer extends ClientResourceFileDeserializer<StageCustom> {


    private static StageCustomArea readStageCustomArea(BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil) {
        byte AreaNo = bufferReader.readSignedByte();
        int FilterNo = bufferReader.readUnsignedByte();
        int GroupNo = bufferReader.readSignedInteger();

        Translation AreaName = null;
        if (lookupUtil != null) {
            AreaName = lookupUtil.getAreaName(AreaNo);
        }

        return new StageCustomArea(AreaNo, AreaName, FilterNo, GroupNo);
    }

    @Override
    protected StageCustom parseClientResourceFile(Path filePath, BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageCustom(
                bufferReader.readNullTerminatedString(),
                bufferReader.readNullTerminatedString(),
                bufferReader.readArray(StageCustomDeserializer::readStageCustomArea, lookupUtil)
        );
    }
}
