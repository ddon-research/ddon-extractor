package org.sehkah.ddon.tools.extractor.lib.common.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

/**
 * This is a 'marker' interface to support generic deserializers.
 * Any class implementing this interface denotes a top-level client resource which should be eligible for deserialization or serialization.
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public abstract class TopLevelClientResource {
    protected FileHeader fileHeader;
    protected int FileSize;
}
