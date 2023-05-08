package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.StageMap;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.StageMapParam;

import java.util.List;

public class StageMapDeserializer extends FileDeserializer<List<StageMap>> {
    public StageMapDeserializer() {
        super(ClientResourceFile.rStageMap);
    }

    private static StageMapParam readParam(FileReader reader) {
        return new StageMapParam(
                reader.readUnsignedInteger(),
                reader.readFloat(),
                reader.readNullTerminatedString(),
                reader.readVector3f()
        );
    }

    private static StageMap readEntity(FileReader fileReader) {
        return new StageMap(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(StageMapDeserializer::readParam)
        );
    }

    @Override
    protected List<StageMap> readObject(FileReader fileReader) {
        return fileReader.readArray(StageMapDeserializer::readEntity);
    }
}
