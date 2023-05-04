package org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.Deserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.gui_cmn.WarpLocation;

import java.util.List;

public class WarpLocationListDeserializer implements Deserializer {
    public static final WarpLocationListDeserializer INSTANCE = new WarpLocationListDeserializer();
    private static final Logger logger = LogManager.getLogger();

    private WarpLocationListDeserializer() {

    }

    public static List<WarpLocation> deserializeObject(FileReader fileReader) {
        long version = fileReader.readUnsignedInteger();
        logger.info("version: '{}'", version);
        return fileReader.readArray(WarpLocationListDeserializer::readEntity);
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
    public Object deserialize(FileReader fileReader) {
        return deserializeObject(fileReader);
    }
}
