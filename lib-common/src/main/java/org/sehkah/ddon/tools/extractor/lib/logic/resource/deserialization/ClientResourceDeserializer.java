package org.sehkah.ddon.tools.extractor.lib.logic.resource.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;

/**
 * TODO #1 Create a custom jackson deserializer and introduce a new metatype annotation to enrich each field with an original C-style type
 *  e.g. @CType("u32") long ID => a custom parser will then automatically apply the appropriate bufferread operation based on this
 *  This can be expanded for binary formats as well via @Xfs
 * TODO #2 Replace a majority of manually crafted deserializer logic once everything is stable and avoid record classes
 */

public interface ClientResourceDeserializer<T extends TopLevelClientResource> {
    T deserialize(BufferReader bufferReader);
}
