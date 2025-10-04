package org.sehkah.ddon.tools.extractor.api.logic.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;

import java.io.IOException;
import java.util.List;

public class GMDTranslationSerializer {
    private final CsvMapper objectMapper;
    private static CsvSchema translationSchema;

    private GMDTranslationSerializer(CsvMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public static GMDTranslationSerializer get() {
        CsvMapper objectMapper = initializeMapper();
        translationSchema = objectMapper.schemaFor(GMDTranslation.class);
        return new GMDTranslationSerializer(objectMapper);
    }

    private static CsvMapper initializeMapper() {
        CsvMapper.Builder csvBuilder = CsvMapper.builder();
        csvBuilder.findAndAddModules();
        csvBuilder.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        csvBuilder.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        csvBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
        csvBuilder.propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
        csvBuilder.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
        return csvBuilder.build();
    }

    public String serialize(GMDTranslation deserialized) {
        try {
            return objectMapper.writeValueAsString(deserialized);
        } catch (JsonProcessingException e) {
            throw new TechnicalException(e);
        }
    }

    public List<GMDTranslation> deserialize(String serialized) {
        try {
            return objectMapper
                    .readerForListOf(GMDTranslation.class)
                    .with(translationSchema)
                    .with(CsvParser.Feature.WRAP_AS_ARRAY)
                    .with(CsvParser.Feature.ALLOW_TRAILING_COMMA)
                    .with(CsvParser.Feature.SKIP_EMPTY_LINES)
                    .with(CsvParser.Feature.ALLOW_COMMENTS)
                    .with(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
                    .readValue(serialized);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }
}
