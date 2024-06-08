package org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;

/**
 * TODO #1 Create a custom jackson deserializer and introduce a new metatype annotation to enrich each field with an original C-style type
 *  e.g. @CType("u32") long ID => a custom parser will then automatically apply the appropriate bufferread operation based on this
 *  This can be expanded for binary formats as well via @Xfs
 * TODO #2 Replace a majority of manually crafted deserializer logic once everything is stable and avoid record classes
 */

public interface ClientResourceDeserializer<T extends Resource> {
    T deserialize(ClientResourceFile<T> clientResourceFile, BufferReader bufferReader, ResourceMetadataLookupUtil lookupUtil);
}
