package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.gui_cmn.WarpLocation;

import java.util.List;

public class WarpLocationDeserializer extends ClientResourceFileDeserializer<List<WarpLocation>> {
    public WarpLocationDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static WarpLocation readEntity(FileReader fileReader) {
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
    protected List<WarpLocation> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(WarpLocationDeserializer::readEntity);
    }
}
