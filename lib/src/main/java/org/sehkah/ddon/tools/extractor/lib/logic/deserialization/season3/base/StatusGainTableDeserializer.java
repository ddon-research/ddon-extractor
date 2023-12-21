package org.sehkah.ddon.tools.extractor.lib.logic.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.logic.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.StatusGain;
import org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.base.StatusGainTable;

public class StatusGainTableDeserializer extends ClientResourceFileDeserializer {
    public StatusGainTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StatusGain readStatusGain(FileReader fileReader) {
        return new StatusGain(
                fileReader.readUnsignedInteger(),
                fileReader.readUnsignedInteger()
        );
    }

    @Override
    protected StatusGainTable parseClientResourceFile(FileReader fileReader) {
        return new StatusGainTable(fileReader.readArray(StatusGainTableDeserializer::readStatusGain));
    }
}
