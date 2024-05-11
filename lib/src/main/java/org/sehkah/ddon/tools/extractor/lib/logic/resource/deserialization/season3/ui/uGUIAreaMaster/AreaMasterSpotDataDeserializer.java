package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.ui.uGUIAreaMaster;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterSpotData;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.ui.uGUIAreaMaster.AreaMasterSpotDataList;

public class AreaMasterSpotDataDeserializer extends ClientResourceFileDeserializer {
    public AreaMasterSpotDataDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaMasterSpotData readAreaMasterSpotData(FileReader fileReader) {
        return new AreaMasterSpotData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readFloat(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedByte(),
                fileReader.readBoolean()
        );
    }

    @Override
    protected AreaMasterSpotDataList parseClientResourceFile(FileReader fileReader) {
        return new AreaMasterSpotDataList(fileReader.readArray(AreaMasterSpotDataDeserializer::readAreaMasterSpotData));
    }
}
