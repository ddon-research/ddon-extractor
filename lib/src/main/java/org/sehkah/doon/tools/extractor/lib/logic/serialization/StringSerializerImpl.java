package org.sehkah.doon.tools.extractor.lib.logic.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.sehkah.doon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.doon.tools.extractor.lib.common.error.SerializerException;

public class StringSerializerImpl implements Serializer<TopLevelClientResource> {
    private final ObjectMapper objectMapper;

    public StringSerializerImpl(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        MetaInformationIntrospector metaInformationIntrospector = new MetaInformationIntrospector(shouldSerializeMetaInformation);
        switch (preferredSerializationType) {
            case JSON, json -> {
                JsonMapper.Builder jsonBuilder = JsonMapper.builder();
                jsonBuilder.findAndAddModules();
                jsonBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                jsonBuilder.enable(SerializationFeature.INDENT_OUTPUT);
                jsonBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                jsonBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                jsonBuilder.annotationIntrospector(metaInformationIntrospector);
                this.objectMapper = jsonBuilder.build();
            }
            case YAML, yaml, yml -> {
                YAMLMapper.Builder yamlBuilder = YAMLMapper.builder();
                yamlBuilder.findAndAddModules();
                yamlBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
                yamlBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                yamlBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
                yamlBuilder.annotationIntrospector(metaInformationIntrospector);
                this.objectMapper = yamlBuilder.build();
            }
            default -> this.objectMapper = null;
        }
    }

    @Override
    public String serialize(TopLevelClientResource deserialized) {
        try {
            return objectMapper.writeValueAsString(deserialized);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }

    @Override
    public TopLevelClientResource deserialize(String serialized, Class<TopLevelClientResource> cls) {
        try {
            return objectMapper.readValue(serialized, cls);
        } catch (JsonProcessingException e) {
            throw new SerializerException(e);
        }
    }

    @Override
    public byte[] serializeResource(TopLevelClientResource deserialized) throws SerializerException {
        return new byte[0];
    }
}
