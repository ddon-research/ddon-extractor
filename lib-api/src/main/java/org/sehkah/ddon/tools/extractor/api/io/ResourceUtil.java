package org.sehkah.ddon.tools.extractor.api.io;

import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;

import java.io.IOException;
import java.io.InputStream;

public class ResourceUtil {
    private ResourceUtil() {

    }

    public static byte[] loadResourceFile(String resourceFilePath) {
        try (InputStream in = ResourceUtil.class.getResourceAsStream(resourceFilePath)) {
            return in.readAllBytes();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }
}
