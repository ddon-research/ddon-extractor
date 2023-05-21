package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;

public interface Deserializer<T extends TopLevelClientResource> {
    T deserialize(FileReader fileReader);
}
