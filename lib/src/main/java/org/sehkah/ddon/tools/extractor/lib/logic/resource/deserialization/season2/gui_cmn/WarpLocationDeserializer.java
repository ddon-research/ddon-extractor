package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season2.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.gui_cmn.WarpLocation;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.gui_cmn.WarpLocationList;

public class WarpLocationDeserializer extends ClientResourceFileDeserializer {
    public WarpLocationDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WarpLocation readWarpLocation(FileReader fileReader) {
        return new WarpLocation(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readSignedInteger(),
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedShort(),
                fileReader.readUnsignedByte()
        );
    }

    @Override
    protected WarpLocationList parseClientResourceFile(FileReader fileReader) {
        return new WarpLocationList(fileReader.readArray(WarpLocationDeserializer::readWarpLocation));
    }
}