package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster.AreaMasterSpotData;

import java.util.List;

public class AreaMasterSpotDataDeserializer extends FileDeserializer<List<AreaMasterSpotData>> {
    public AreaMasterSpotDataDeserializer() {
        super(ClientResourceFile.rAreaMasterSpotData);
    }

    private static AreaMasterSpotData readEntity(FileReader fileReader) {
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
    protected List<AreaMasterSpotData> readObject(FileReader fileReader) {
        return fileReader.readArray(AreaMasterSpotDataDeserializer::readEntity);
    }
}
