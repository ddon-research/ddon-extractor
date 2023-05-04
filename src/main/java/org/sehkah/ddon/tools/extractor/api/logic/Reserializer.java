package org.sehkah.ddon.tools.extractor.api.logic;

import org.sehkah.ddon.tools.common.io.BinaryFileReader;

public interface Reserializer {
    Object deserialize(BinaryFileReader binaryFileReader);

}
