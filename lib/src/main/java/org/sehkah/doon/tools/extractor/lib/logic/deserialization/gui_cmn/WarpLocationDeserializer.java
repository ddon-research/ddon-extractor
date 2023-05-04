package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.WarpLocation;

public class WarpLocationDeserializer extends FileDeserializer {
    public WarpLocationDeserializer(FileReader fileReader) {
        super(ExtractionType.WARP_LOCATION, fileReader);
    }

    private static WarpLocation readEntity(FileReader reader) {
        return new WarpLocation(
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readUnsignedInteger(),
                reader.readSignedInteger(),
                reader.readUnsignedInteger(),
                reader.readUnsignedShort(),
                reader.readUnsignedShort(),
                reader.readUnsignedByte(),
                reader.readUnsignedInteger()
        );
    }

    @Override
    public Object deserialize() {
        if (!isVersionValid()) {
            return null;
        }
        return fileReader.readArray(WarpLocationDeserializer::readEntity);
    }
}
