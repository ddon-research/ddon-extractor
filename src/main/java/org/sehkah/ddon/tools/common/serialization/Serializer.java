package org.sehkah.ddon.tools.common.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Serializer {
    <T> String serialize(T deserialized) throws JsonProcessingException;

    <T> T deserialize(String serialized, Class<T> cls) throws JsonProcessingException;

    <T> T deserializeJson(String serialized, Class<T> cls) throws JsonProcessingException;

    <T> String serializeJson(T deserialized) throws JsonProcessingException;

    <T> T deserializeYaml(String serialized, Class<T> cls) throws JsonProcessingException;

    <T> String serializeYaml(T deserialized) throws JsonProcessingException;
}
