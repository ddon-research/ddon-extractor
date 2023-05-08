package org.sehkah.doon.tools.extractor.lib.logic.deserialization.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.FileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.base.StatusGain;

import java.util.List;

public class StatusGainTableDeserializer extends FileDeserializer<List<StatusGain>> {
    public StatusGainTableDeserializer() {
        super(ClientResourceFile.rStatusGainTable);
    }

    private static StatusGain readEntity(FileReader fileReader) {
        return new StatusGain(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<StatusGain> readObject(FileReader fileReader) {
        return fileReader.readArray(StatusGainTableDeserializer::readEntity);
    }
}
