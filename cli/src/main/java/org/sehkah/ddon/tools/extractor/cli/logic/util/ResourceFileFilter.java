package org.sehkah.ddon.tools.extractor.cli.logic.util;

import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFileExtension;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Builds file filtering predicates based on command options.
 */
public final class ResourceFileFilter {
    private ResourceFileFilter() {
    }

    public static Predicate<Path> build(boolean unpackArchives, boolean unpackArchivesExclusively, Set<String> ignoreExtensions) {
        if (unpackArchives && unpackArchivesExclusively) {
            String arcFileExtension = ClientResourceFileExtension.getFileExtensions(ClientResourceFileExtension.rArchive);
            return path -> path.getFileName().toString().endsWith(arcFileExtension);
        } else {
            Set<String> supportedFileExtensions = new HashSet<>(ClientResourceFileExtension.getSupportedFileExtensions());
            supportedFileExtensions.removeAll(ignoreExtensions);
            return path -> {
                String fileName = path.getFileName().toString();
                for (String ext : supportedFileExtensions) {
                    if (fileName.endsWith(ext)) {
                        return true;
                    }
                }
                return false;
            };
        }
    }
}
