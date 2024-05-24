package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season3.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.StatusGain;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.base.StatusGainTable;

public class StatusGainTableDeserializer extends ClientResourceFileDeserializer {
    public StatusGainTableDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static StatusGain readStatusGain(BufferReader bufferReader) {
        return new StatusGain(
                bufferReader.readUnsignedInteger(),
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected StatusGainTable parseClientResourceFile(BufferReader bufferReader) {
        return new StatusGainTable(bufferReader.readArray(StatusGainTableDeserializer::readStatusGain));
    }
}
