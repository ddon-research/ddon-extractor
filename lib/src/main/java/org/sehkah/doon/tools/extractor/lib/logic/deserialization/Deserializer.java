package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

public interface Deserializer {
    Object deserialize();

    Object deserialize(boolean addMetaInformation);
}
