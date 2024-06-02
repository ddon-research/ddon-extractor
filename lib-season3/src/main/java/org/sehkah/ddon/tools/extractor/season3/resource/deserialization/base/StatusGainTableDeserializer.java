package org.sehkah.ddon.tools.extractor.season3.resource.deserialization.base;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.StatusGain;
import org.sehkah.ddon.tools.extractor.season3.resource.entity.base.StatusGainTable;

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
