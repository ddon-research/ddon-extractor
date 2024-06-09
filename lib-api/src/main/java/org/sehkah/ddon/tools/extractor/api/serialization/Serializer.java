package org.sehkah.ddon.tools.extractor.api.serialization;


import org.sehkah.ddon.tools.extractor.api.error.SerializerException;

public interface Serializer<T> {
    String serialize(T deserialized) throws SerializerException;

    T deserialize(String serialized);
}
