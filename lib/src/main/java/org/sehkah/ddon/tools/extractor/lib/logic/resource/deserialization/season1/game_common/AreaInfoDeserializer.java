package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.season1.game_common;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization.ClientResourceFileDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.AreaInfo;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season1.game_common.AreaInfoList;

/**
 * Season 1, season 2 & season 3 all share the same header version 2, but season 1 lacks the position data for areas.
 */
public class AreaInfoDeserializer extends ClientResourceFileDeserializer {
    public AreaInfoDeserializer(ClientResourceFile clientResourceFile) {
        super(clientResourceFile);
    }

    private static AreaInfo readAreaInfo(BufferReader bufferReader) {
        return new AreaInfo(
                bufferReader.readUnsignedInteger()
        );
    }

    @Override
    protected AreaInfoList parseClientResourceFile(BufferReader bufferReader) {
        return new AreaInfoList(bufferReader.readArray(AreaInfoDeserializer::readAreaInfo));
    }
}
