package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.gui_cmn.WarpLocation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.gui_cmn.WarpLocationList;

public class WarpLocationDeserializer extends ClientResourceFileDeserializer {
    public WarpLocationDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WarpLocation readWarpLocation(BufferReader bufferReader) {
        return new WarpLocation(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readSignedInteger(),
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedShort(),
                bufferReader.readUnsignedByte()
        );
    }

    @Override
    protected WarpLocationList parseClientResourceFile(BufferReader bufferReader) {
        return new WarpLocationList(bufferReader.readArray(WarpLocationDeserializer::readWarpLocation));
    }
}
