package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.StageMap;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.StageMapList;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.StageMapParam;

public class StageMapDeserializer extends ClientResourceFileDeserializer {
    public StageMapDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StageMapParam readParam(FileReader reader) {
        return new StageMapParam(
                reader.readUnsignedInteger(),
                reader.readFloat(),
                reader.readNullTerminatedString(),
                reader.readVector3f()
        );
    }

    private static StageMap readStageMap(FileReader fileReader) {
        return new StageMap(
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readFloat(),
                fileReader.readUnsignedInteger(),
                fileReader.readArray(StageMapDeserializer::readParam)
        );
    }

    @Override
    protected StageMapList parseClientResourceFile(FileReader fileReader) {
        return new StageMapList(fileReader.readArray(StageMapDeserializer::readStageMap));
    }
}
