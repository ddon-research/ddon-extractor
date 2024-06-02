package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.StageMap;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.StageMapList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.gui_cmn.StageMapParam;

public class StageMapDeserializer extends ClientResourceFileDeserializer {
    public StageMapDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

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
    protected StageMapList parseClientResourceFile(BufferReader bufferReader) {
        return new StageMapList(bufferReader.readArray(StageMapDeserializer::readStageMap));
    }
}
