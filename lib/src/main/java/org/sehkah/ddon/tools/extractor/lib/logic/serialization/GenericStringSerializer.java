package org.sehkah.ddon.tools.extractor.lib.logic.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;

public class GenericStringSerializer {
    private final ObjectMapper objectMapper;

    private GenericStringSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public static GenericStringSerializer get(SerializationFormat preferredSerializationType) {
        ObjectMapper objectMapper = initializeMapper(preferredSerializationType);
        return new GenericStringSerializer(objectMapper);
    }

    private static ObjectMapper initializeMapper(SerializationFormat preferredSerializationType) {
        return switch (preferredSerializationType) {
            case json -> {
                JsonMapper.Builder jsonBuilder = JsonMapper.builder();
                jsonBuilder.findAndAddModules();
                jsonBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                jsonBuilder.enable(SerializationFeature.INDENT_OUTPUT);
                jsonBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                jsonBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                yield jsonBuilder.build();
            }
            case yaml -> {
                YAMLMapper.Builder yamlBuilder = YAMLMapper.builder();
                yamlBuilder.findAndAddModules();
                yamlBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                yamlBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                yamlBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                yield yamlBuilder.build();
            }
        };
    }

    public String serialize(Object deserialized) {
        try {
            return objectMapper.writeValueAsString(deserialized);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }

    public <T> T deserialize(String serialized, TypeReference<T> ref) {
        try {
            return objectMapper.readValue(serialized, ref);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }
}
