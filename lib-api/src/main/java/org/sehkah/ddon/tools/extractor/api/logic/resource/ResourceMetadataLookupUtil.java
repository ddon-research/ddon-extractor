package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ResourceCache;

import java.nio.file.Path;

/**
 * This is a util class which supports looking up message-related meta information via entity classes.
 * Must be initialized before usage.
 * <p>
 * TODO: Rework how deserializers are initialized/retrieved and use the client manager in some way
 * TODO: Replace existing manual message lookups with framework resources
 * Idea: Get rid of records and use class inheritance with the ability to look up file-relative resources?
 */
@Slf4j
public abstract class ResourceMetadataLookupUtil {
    protected final ResourceCache cache;

    public ResourceMetadataLookupUtil(Path clientRootFolder) {
        cache = new ResourceCache(clientRootFolder);
    }

    public abstract String getMessage(String filePath, long messageIndex);

    public abstract String getMessageKey(String filePath, long messageIndex);

    public abstract String getMessage(String filePath, String key);

}
