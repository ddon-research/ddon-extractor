package org.sehkah.ddon.tools.extractor.lib.common.io;

import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.logic.resource.DynamicResourceLookupUtil;

import java.io.IOException;
import java.io.InputStream;

public class ResourceUtil {
    private ResourceUtil() {

    }

    public static byte[] loadResourceFile(String resourceFilePath) {
        try (InputStream in = DynamicResourceLookupUtil.class.getResourceAsStream(resourceFilePath)) {
            return in.readAllBytes();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }
}
