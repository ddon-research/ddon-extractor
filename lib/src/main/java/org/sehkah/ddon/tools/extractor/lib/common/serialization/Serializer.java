package org.sehkah.ddon.tools.extractor.lib.common.serialization;


import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;

public interface Serializer<T> {
    String serialize(T deserialized) throws SerializerException;

    T deserialize(String serialized);
}
