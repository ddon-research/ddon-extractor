package org.sehkah.ddon.tools.extractor.season1.logic.resource.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn.WarpLocation;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.gui_cmn.WarpLocationList;

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
                bufferReader.readUnsignedByte(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected WarpLocationList parseClientResourceFile(BufferReader bufferReader) {
        return new WarpLocationList(bufferReader.readArray(WarpLocationDeserializer::readWarpLocation));
    }
}
