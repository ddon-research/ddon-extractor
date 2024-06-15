package org.sehkah.ddon.tools.extractor.api.util;

import java.nio.file.Path;

public class PathUtil {
    private PathUtil() {

    }

    public static String getRelativeFilePathFromRom(Path path) {
        Path normalized = path.toAbsolutePath().normalize();
        // Assume that drive letter, DDON folder name and nativePC and rom folder must be stripped
        int romIndex = -1;
        for (int i = 0; i < normalized.getNameCount(); i++) {
            if (normalized.getName(i).toString().equals("rom")) {
                romIndex = i;
                break;
            }
        }
        normalized = normalized.subpath(romIndex + 1, normalized.getNameCount());
        return normalized.toString().replace("\\", "/");
    }
}
