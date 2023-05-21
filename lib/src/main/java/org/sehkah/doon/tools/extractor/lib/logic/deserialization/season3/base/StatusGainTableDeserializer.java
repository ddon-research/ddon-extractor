package org.sehkah.doon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.doon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.entity.season3.base.StatusGain;

import java.util.List;

public class StatusGainTableDeserializer extends ClientResourceFileDeserializer<List<StatusGain>> {
    public StatusGainTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StatusGain readEntity(FileReader fileReader) {
        return new StatusGain(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected List<StatusGain> parseClientResourceFile(FileReader fileReader) {
        return fileReader.readArray(StatusGainTableDeserializer::readEntity);
    }
}
