package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.stage;

import org.sehkah.ddon.tools.extractor.api.entity.FileHeader;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageConnect;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageConnectConnect;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage.StageConnectData;

public class StageConnectDeserializer extends ClientResourceFileDeserializer<StageConnect> {


    private static StageConnectConnect readStageConnectConnect(BufferReader bufferReader) {
        return new StageConnectConnect(
                bufferReader.readSignedShort(),
                bufferReader.readSignedShort(),
                bufferReader.readFixedLengthArray(6, BufferReader::readSignedShort),
                bufferReader.readUnsignedInteger()
        );
    }

    private static StageConnectData readStageConnectData(BufferReader bufferReader) {
        return new StageConnectData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readVector3f(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StageConnect parseClientResourceFile(BufferReader bufferReader, FileHeader fileHeader, ResourceMetadataLookupUtil lookupUtil) {
        return new StageConnect(
                bufferReader.readArray(StageConnectDeserializer::readStageConnectData),
                bufferReader.readArray(StageConnectDeserializer::readStageConnectConnect)
        );
    }
}
