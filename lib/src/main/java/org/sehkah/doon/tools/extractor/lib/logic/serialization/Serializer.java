package org.sehkah.doon.tools.extractor.lib.logic.serialization;


import org.sehkah.doon.tools.extractor.lib.common.error.SerializerException;

public interface Serializer {
    <T> String serialize(T deserialized) throws SerializerException;

    <T> T deserialize(String serialized, Class<T> cls) throws SerializerException;
}
