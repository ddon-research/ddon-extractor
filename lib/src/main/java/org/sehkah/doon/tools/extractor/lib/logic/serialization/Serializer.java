package org.sehkah.doon.tools.extractor.lib.logic.serialization;


import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.common.error.SerializerException;

public interface Serializer<T extends TopLevelClientResource> {
    String serialize(T deserialized) throws SerializerException;

    byte[] serializeResource(T deserialized) throws SerializerException;
}
