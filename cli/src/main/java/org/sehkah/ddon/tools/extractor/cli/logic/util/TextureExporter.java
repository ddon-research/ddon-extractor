package org.sehkah.ddon.tools.extractor.cli.logic.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.common.logic.resource.ClientResourceFileManager;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.DirectDrawSurface;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.texture.Texture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
@RequiredArgsConstructor
public class TextureExporter {
    private final ClientResourceFileManager clientResourceFileManager;
    private final FileChangeDetector fileChangeDetector;

    /**
     * Exports the provided texture as DDS.
     *
     * @param texture      texture instance
     * @param outputFolder base output folder (already ensured to exist)
     * @param fileName     original file name (with extension)
     * @param outputFile   main serialized output file name (fileName + "." + format)
     * @throws IOException on write issues (propagated to caller for uniform handling)
     */
    public void export(Texture texture, Path outputFolder, String fileName, String outputFile) throws IOException {
        DirectDrawSurface dds = texture.toDirectDrawSurface();
        Path ddsPath = outputFolder.resolve(fileName + ".dds");
        byte[] ddsBytes = clientResourceFileManager.getSerializer(outputFile + ".dds", dds).serializeResource(dds);
        boolean writeDds = fileChangeDetector.shouldWrite(ddsPath, ddsBytes);
        if (!writeDds) {
            log.debug("Skipping unchanged DDS file '{}'.", ddsPath);
        } else {
            Files.write(ddsPath, ddsBytes, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        }
    }
}
