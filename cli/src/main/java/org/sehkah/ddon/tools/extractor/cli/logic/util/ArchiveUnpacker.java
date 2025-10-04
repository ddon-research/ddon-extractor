package org.sehkah.ddon.tools.extractor.cli.logic.util;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.Archive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

/**
 * Handles unpacking of Archive (.arc) resources.
 */
@Slf4j
public class ArchiveUnpacker {

    /**
     * Unpacks the provided archive into a subfolder named after the original file (without extension).
     *
     * @param archive            archive instance
     * @param parentOutputFolder the current output folder of the archive descriptor file (already existing)
     * @param fileName           original file name including extension (used to derive subfolder)
     * @throws IOException if any file operation fails (caller handles logging consistency)
     */
    public void unpack(Archive archive, Path parentOutputFolder, String fileName) throws IOException {
        Path archiveOutputRoot = parentOutputFolder.resolve(fileName.substring(0, fileName.lastIndexOf('.')));
        for (Map.Entry<String, byte[]> entry : archive.getResourceFiles().entrySet()) {
            String arcFile = entry.getKey();
            byte[] bytes = entry.getValue();
            Path arcFilePath = Paths.get(arcFile);
            Path arcOutputFolder = archiveOutputRoot.resolve(arcFilePath.subpath(0, Math.max(1, arcFilePath.getNameCount() - 1)));
            boolean arcMkdirsSucceeded = arcOutputFolder.toFile().mkdirs();
            if (!arcMkdirsSucceeded && !Files.isDirectory(arcOutputFolder)) {
                log.error("Failed to create folders for arc file.");
                throw new IOException("Failed to create folders for arc file: " + arcOutputFolder);
            }
            Path arcOutputFilePath = arcOutputFolder.resolve(arcFilePath.getFileName());
            log.info("Outputting to file '{}'.", arcOutputFilePath);
            Files.write(arcOutputFilePath, bytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
