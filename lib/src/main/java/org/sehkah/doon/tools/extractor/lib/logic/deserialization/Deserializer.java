package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.common.io.FileReader;

public interface Deserializer {
    Object deserialize(FileReader fileReader);
}
