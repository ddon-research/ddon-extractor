package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtensionMap;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster.AreaMasterSpotData;

public class AreaMasterSpotDataDeserializer extends FileDeserializer {
    public AreaMasterSpotDataDeserializer(FileReader fileReader) {
        super(ExtensionMap.rAreaMasterSpotData, fileReader);
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
    protected Object readObject() {
        return fileReader.readArray(AreaMasterSpotDataDeserializer::readEntity);
    }

    @Override
    protected Object readObjectWithMetaInformation() {
        return readObject();
    }
}
