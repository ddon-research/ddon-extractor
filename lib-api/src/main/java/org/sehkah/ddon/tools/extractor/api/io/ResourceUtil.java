package org.sehkah.ddon.tools.extractor.api.io;

import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ResourceUtil {
    private ResourceUtil() {

    }

    public static byte[] loadResourceFile(String resourceFilePath) {
        try (InputStream in = ResourceUtil.class.getClassLoader().getResourceAsStream(resourceFilePath)) {
            return in.readAllBytes();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public static List<String> loadResourceFileLines(String resourceFilePath) {
        try (InputStream in = ResourceUtil.class.getClassLoader().getResourceAsStream(resourceFilePath)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            return reader.lines().toList();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }
}
