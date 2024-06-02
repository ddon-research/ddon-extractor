package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterSpotData;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterSpotDataList;

public class AreaMasterSpotDataDeserializer extends ClientResourceFileDeserializer {
    public AreaMasterSpotDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaMasterSpotData readAreaMasterSpotData(BufferReader bufferReader) {
        return new AreaMasterSpotData(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readFloat(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedByte(),
                bufferReader.readBoolean()
        );
    }

    @Override
    protected AreaMasterSpotDataList parseClientResourceFile(BufferReader bufferReader) {
        return new AreaMasterSpotDataList(bufferReader.readArray(AreaMasterSpotDataDeserializer::readAreaMasterSpotData));
    }
}
