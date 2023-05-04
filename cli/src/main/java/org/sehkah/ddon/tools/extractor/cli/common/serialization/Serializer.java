package org.sehkah.ddon.tools.extractor.cli.common.serialization;

import org.sehkah.ddon.tools.extractor.cli.common.error.SerializerException;

public interface Serializer {
    <T> String serialize(T deserialized) throws SerializerException;

    <T> T deserialize(String serialized, Class<T> cls) throws SerializerException;

    <T> T deserializeJson(String serialized, Class<T> cls) throws SerializerException;

    <T> String serializeJson(T deserialized) throws SerializerException;

    <T> T deserializeYaml(String serialized, Class<T> cls) throws SerializerException;

    <T> String serializeYaml(T deserialized) throws SerializerException;
}
