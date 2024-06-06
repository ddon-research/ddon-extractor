package org.sehkah.ddon.tools.extractor.api.logic.resource.serialization;


import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.api.error.SerializerException;

public interface ClientResourceSerializer<T extends TopLevelClientResource> {
    byte[] serializeResource(T deserialized) throws SerializerException;
}
