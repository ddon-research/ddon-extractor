package org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ResourceCache {
    private final Map<String, Resource> cache = new ConcurrentHashMap<>(128);
    protected Path clientResourceFolder;

    public ResourceCache(Path clientRootFolder) {
        if (clientRootFolder != null) {
            clientResourceFolder = clientRootFolder.resolve("nativePC").resolve("rom");
        } else {
            throw new TechnicalException("The client root folder is not configured, cache will fail to construct.");
        }
    }

    private static <T extends Resource> T loadResource(ClientResourceFile<T> clientResourceFile, Path filePath) {
        return loadResource(clientResourceFile, filePath, null);
    }

    private static <T extends Resource> T loadResource(ClientResourceFile<T> clientResourceFile, Path filePath, ResourceMetadataLookupUtil lookupUtil) {
        byte[] input;
        try {
            input = Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
        return clientResourceFile.getDeserializer().deserialize(filePath, clientResourceFile, new BinaryReader(input), lookupUtil);
    }

    public <T extends Resource> T getResource(String filePath, ClientResourceFile<T> clientResourceFile) {
        return getResource(filePath, clientResourceFile, null);
    }

    public <T extends Resource> T getResource(String filePath, ClientResourceFile<T> clientResourceFile, ResourceMetadataLookupUtil lookupUtil) {
        if (cache.containsKey(filePath)) {
            return (T) cache.get(filePath);
        } else {
            T resource = loadResource(clientResourceFile, clientResourceFolder.resolve(filePath), lookupUtil);
            cache.put(filePath, resource);
            return resource;
        }
    }
}
