package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization.ResourceCache;

import java.nio.file.Path;

@Slf4j
public abstract class ResourceMetadataLookupUtil {
    protected final ResourceCache cache;

    protected ResourceMetadataLookupUtil(Path clientRootFolder) {
        cache = new ResourceCache(clientRootFolder);
    }

    public abstract String getMessage(String filePath, long messageIndex);

    public abstract String getMessageKey(String filePath, long messageIndex);

    public abstract String getMessage(String filePath, String key);

    public abstract String getNpcName(long npcId);
}
