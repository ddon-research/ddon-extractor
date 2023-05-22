package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn.WarpLocation;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.gui_cmn.WarpLocationList;

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
                fileReader.readUnsignedByte(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected WarpLocationList parseClientResourceFile(FileReader fileReader) {
        return new WarpLocationList(fileReader.readArray(WarpLocationDeserializer::readWarpLocation));
    }
}
