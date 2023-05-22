package org.sehkah.ddon.tools.extractor.lib.logic.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;

public interface ClientResourceDeserializer<T extends TopLevelClientResource> {
    T deserialize(FileReader fileReader);
}
