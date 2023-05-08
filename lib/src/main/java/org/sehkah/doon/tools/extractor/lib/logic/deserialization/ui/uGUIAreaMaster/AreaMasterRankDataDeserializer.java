package org.sehkah.doon.tools.extractor.lib.logic.deserialization.ui.uGUIAreaMaster;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.ui.uGUIAreaMaster.AreaMasterRankData;

import java.util.List;

public class AreaMasterRankDataDeserializer extends FileDeserializer<List<AreaMasterRankData>> {
    public AreaMasterRankDataDeserializer() {
        super(ClientResourceFile.rAreaMasterRankData);
    }

    private static AreaMasterRankData readEntity(FileReader fileReader) {
        return new AreaMasterRankData(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected List<AreaMasterRankData> readObject(FileReader fileReader) {
        return fileReader.readArray(AreaMasterRankDataDeserializer::readEntity);
    }
}
