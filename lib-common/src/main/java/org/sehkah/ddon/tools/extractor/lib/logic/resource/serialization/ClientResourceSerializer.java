package org.sehkah.ddon.tools.extractor.lib.logic.resource.serialization;


import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;

public interface ClientResourceSerializer<T extends TopLevelClientResource> {
    byte[] serializeResource(T deserialized) throws SerializerException;
}
