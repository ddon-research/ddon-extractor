package org.sehkah.ddon.tools.extractor.lib.logic.packet.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformationIntrospector;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.Serializer;

public class PacketStringSerializer implements Serializer<Packet> {
    private final ObjectMapper objectMapper;

    private PacketStringSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public static Serializer<Packet> get(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        ObjectMapper objectMapper = initializeMapper(preferredSerializationType, shouldSerializeMetaInformation);
        return new PacketStringSerializer(objectMapper);
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
                yamlBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                if (!shouldSerializeMetaInformation) {
                    yamlBuilder.annotationIntrospector(metaInformationIntrospector);
                }
                yield yamlBuilder.build();
            }
        };
    }

    @Override
    public String serialize(Packet deserialized) {
        try {
            return objectMapper.writeValueAsString(deserialized);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }

    @Override
    public Packet deserialize(String serialized) {
        try {
            return objectMapper.readValue(serialized, Packet.class);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }
}
