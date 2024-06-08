package org.sehkah.ddon.tools.extractor.api.logic.resource.serialization;


import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.SerializerException;

public interface ClientResourceSerializer<T extends Resource> {
    byte[] serializeResource(T deserialized) throws SerializerException;
}
