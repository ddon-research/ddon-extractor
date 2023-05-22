package org.sehkah.doon.tools.extractor.lib.common.entity;

import lombok.Data;

/**
 * This is a 'marker' interface to support generic deserializers.
 * Any class implementing this interface denotes a top-level client resource which should be eligible for deserialization or serialization.
 */
@Data
public abstract class TopLevelClientResource {
    protected int FileSize;
    protected String MagicString;
    protected long VersionNumber;
}
