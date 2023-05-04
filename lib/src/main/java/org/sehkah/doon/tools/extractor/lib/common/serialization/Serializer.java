package org.sehkah.doon.tools.extractor.lib.common.serialization;

import org.sehkah.doon.tools.extractor.lib.common.error.SerializationException;

public interface Serializer {
    <T> String serialize(T deserialized) throws SerializationException;

    <T> T deserialize(String serialized, Class<T> cls) throws SerializationException;

    <T> T deserializeJson(String serialized, Class<T> cls) throws SerializationException;

    <T> String serializeJson(T deserialized) throws SerializationException;

    <T> T deserializeYaml(String serialized, Class<T> cls) throws SerializationException;

    <T> String serializeYaml(T deserialized) throws SerializationException;
}
