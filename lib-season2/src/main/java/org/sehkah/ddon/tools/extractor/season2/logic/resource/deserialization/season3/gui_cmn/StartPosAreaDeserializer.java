package org.sehkah.ddon.tools.extractor.season2.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.gui_cmn.StartPosArea;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.season3.gui_cmn.StartPosAreaList;

public class StartPosAreaDeserializer extends ClientResourceFileDeserializer {
    public StartPosAreaDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StartPosArea readStartPosArea(BufferReader bufferReader) {
        return new StartPosArea(
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort()
        );
    }

    @Override
    protected StartPosAreaList parseClientResourceFile(BufferReader bufferReader) {
        return new StartPosAreaList(bufferReader.readArray(StartPosAreaDeserializer::readStartPosArea));
    }
}
