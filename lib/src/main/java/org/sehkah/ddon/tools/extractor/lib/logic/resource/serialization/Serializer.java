package org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization;


import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;

public interface Serializer<T extends TopLevelClientResource> {
    String serialize(T deserialized) throws SerializerException;

    T deserialize(String serialized);
}
