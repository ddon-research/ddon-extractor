package org.sehkah.ddon.tools.extractor.api.logic.resource.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.entity.TopLevelClientResource;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.io.BinaryReader;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ResourceCache {
    private final Map<String, TopLevelClientResource> cache = new ConcurrentHashMap<>(128);
    protected Path clientResourceFolder;

    public ResourceCache(Path clientRootFolder) {
        if (clientRootFolder != null) {
            clientResourceFolder = clientRootFolder.resolve("nativePC").resolve("rom");
        } else {
            throw new TechnicalException("The client root folder is not configured, cache will fail to construct.");
        }
    }

    private static <T extends TopLevelClientResource> T loadResource(ClientResourceFile<T> clientResourceFile, Path folderPath, String fileName) {
        return loadResource(clientResourceFile, folderPath.resolve(fileName));
    }

    private static <T extends TopLevelClientResource> T loadResource(ClientResourceFile<T> clientResourceFile, Path filePath) {
        byte[] input;
        try {
            input = Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
        return clientResourceFile.getDeserializer().deserialize(clientResourceFile, new BinaryReader(input), null);
    }

    public <T extends TopLevelClientResource> T getResource(String filePath, ClientResourceFile<T> clientResourceFile) {
        return (T) cache.putIfAbsent(filePath, loadResource(clientResourceFile, clientResourceFolder.resolve(filePath)));
    }
}
