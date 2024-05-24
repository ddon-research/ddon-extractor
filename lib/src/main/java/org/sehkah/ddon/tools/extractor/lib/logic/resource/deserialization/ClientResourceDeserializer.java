package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;

public interface ClientResourceDeserializer<T extends TopLevelClientResource> {
    T deserialize(BufferReader bufferReader);
}
