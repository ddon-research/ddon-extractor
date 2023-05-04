package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.Deserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ExtractionType;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.LandInfo;

import java.util.List;

public class LandInfoDeserializer implements Deserializer {
    public static final LandInfoDeserializer INSTANCE = new LandInfoDeserializer();
    private static final Logger logger = LogManager.getLogger();

    private LandInfoDeserializer() {

    }

    public static List<LandInfo> deserializeObject(FileReader fileReader) {
        String magic = fileReader.readString(4);
        assert magic.equals(ExtractionType.LAND_INFO.magic);
        logger.info("magic: '{}'", magic);
        long version = fileReader.readUnsignedInteger();
        logger.info("version: '{}'", version);

        return fileReader.readArray(LandInfoDeserializer::readEntity);
    }

    private static LandInfo readEntity(FileReader reader) {
        return new LandInfo(
                reader.readUnsignedInteger(),
                reader.readBoolean(),
                reader.readUnsignedByte(),
                reader.readArray(FileReader::readUnsignedInteger)
        );
    }

    @Override
    public Object deserialize(FileReader fileReader) {
        return deserializeObject(fileReader);
    }
}
