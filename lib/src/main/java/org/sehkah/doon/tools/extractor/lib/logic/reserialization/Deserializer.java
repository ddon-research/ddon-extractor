package org.sehkah.doon.tools.extractor.lib.logic.reserialization;

import org.sehkah.doon.tools.extractor.lib.common.io.BinaryFileReader;

public interface Deserializer {
    Object deserialize(BinaryFileReader binaryFileReader);

}
