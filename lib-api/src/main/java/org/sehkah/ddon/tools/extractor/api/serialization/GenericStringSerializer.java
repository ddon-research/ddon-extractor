package org.sehkah.ddon.tools.extractor.api.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.sehkah.ddon.tools.extractor.api.error.SerializerException;

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
                jsonBuilder.enable(SerializationFeature.INDENT_OUTPUT);
                jsonBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                jsonBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                jsonBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                jsonBuilder.propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
                jsonBuilder.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
                yield jsonBuilder.build();
            }
            case yaml -> {
                YAMLMapper.Builder yamlBuilder = YAMLMapper.builder();
                yamlBuilder.findAndAddModules();
                yamlBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                yamlBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                yamlBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                yamlBuilder.propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
                yamlBuilder.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
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
