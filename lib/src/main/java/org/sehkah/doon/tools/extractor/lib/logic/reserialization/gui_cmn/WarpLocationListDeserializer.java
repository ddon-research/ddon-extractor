package org.sehkah.doon.tools.extractor.lib.logic.reserialization.gui_cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.io.BinaryFileReader;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.WarpLocation;
import org.sehkah.doon.tools.extractor.lib.logic.reserialization.Deserializer;

import java.util.List;

public class WarpLocationListDeserializer implements Deserializer {
    public static final WarpLocationListDeserializer INSTANCE = new WarpLocationListDeserializer();
    private static final Logger logger = LogManager.getLogger();

    private WarpLocationListDeserializer() {

    }

    public static List<WarpLocation> deserializeObject(BinaryFileReader binaryFileReader) {
        long version = binaryFileReader.readUnsignedInteger();
        logger.info("version: '{}'", version);
        return binaryFileReader.readArray(WarpLocationListDeserializer::readEntity);
    }

    private static WarpLocation readEntity(BinaryFileReader reader) {
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

    public Object deserialize(BinaryFileReader binaryFileReader) {
        return deserializeObject(binaryFileReader);
    }
}
