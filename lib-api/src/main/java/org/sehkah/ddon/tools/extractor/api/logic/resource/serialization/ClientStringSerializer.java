package org.sehkah.ddon.tools.extractor.api.logic.resource.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.SerializerException;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformationIntrospector;
import org.sehkah.ddon.tools.extractor.api.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.api.serialization.Serializer;

// TODO: Create factory method for serializers: Client, Generic, Packet
public class ClientStringSerializer implements Serializer<Resource> {
    private final ObjectMapper objectMapper;

    private ClientStringSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public static Serializer<Resource> get(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        ObjectMapper objectMapper = initializeMapper(preferredSerializationType, shouldSerializeMetaInformation);
        return new ClientStringSerializer(objectMapper);
    }

    private static ObjectMapper initializeMapper(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        MetaInformationIntrospector metaInformationIntrospector = new MetaInformationIntrospector();
        return switch (preferredSerializationType) {
            case json -> {
                JsonMapper.Builder jsonBuilder = JsonMapper.builder();
                jsonBuilder.findAndAddModules();
                jsonBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                jsonBuilder.enable(SerializationFeature.INDENT_OUTPUT);
                jsonBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                jsonBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                jsonBuilder.propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
                if (!shouldSerializeMetaInformation) {
                    jsonBuilder.annotationIntrospector(metaInformationIntrospector);
                }
                yield jsonBuilder.build();
            }
            case yaml -> {
                YAMLMapper.Builder yamlBuilder = YAMLMapper.builder();
                yamlBuilder.findAndAddModules();
                yamlBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                yamlBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                yamlBuilder.propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
                if (!shouldSerializeMetaInformation) {
                    yamlBuilder.annotationIntrospector(metaInformationIntrospector);
                }
                yield yamlBuilder.build();
            }
        };
    }

    @Override
    public String serialize(Resource deserialized) {
        try {
            return objectMapper.writeValueAsString(deserialized);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }

    @Override
    public Resource deserialize(String serialized) {
        try {
            return objectMapper.readValue(serialized, Resource.class);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }
}
