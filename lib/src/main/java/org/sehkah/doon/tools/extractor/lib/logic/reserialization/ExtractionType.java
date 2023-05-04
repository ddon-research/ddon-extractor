package org.sehkah.doon.tools.extractor.lib.logic.reserialization;

import java.nio.file.Path;
import java.util.Arrays;

public enum ExtractionType {
    ENEMY_GROUP("game_common", "param", "enemy_group.emg", "emg"),
    UNSUPPORTED("", "", "", "");

    final String arcFile;
    final String arcFilePath;
    final String resourceFileName;
    final String resourceFileExtension;
    ExtractionType(String arcFile, String arcFilePath, String resourceFileName, String resourceFileExtension) {
        this.arcFile = arcFile;
        this.arcFilePath = arcFilePath;
        this.resourceFileName = resourceFileName;
        this.resourceFileExtension = resourceFileExtension;
    }

    public static ExtractionType findByResourceFileName(String resourceFileName) {
        return Arrays.stream(ExtractionType.values()).filter(value -> value.resourceFileName.equals(resourceFileName)).findFirst().orElse(UNSUPPORTED);
    }
    public static ExtractionType findByFilePath(Path filePath) {
        for (ExtractionType value : ExtractionType.values()) {
            if (filePath.toString().replace('\\', '/').endsWith(value.toFilePath())) {
                return value;
            }
        }
        return UNSUPPORTED;
    }

    public String toFilePath(){
        return String.join("/", arcFile, arcFilePath, resourceFileName);
    }

    @Override
    public String toString() {
        return "SupportedExtractionTypes{" +
                "arcFile='" + arcFile + '\'' +
                ", arcFilePath='" + arcFilePath + '\'' +
                ", resourceFileName='" + resourceFileName + '\'' +
                ", resourceFileExtension='" + resourceFileExtension + '\'' +
                '}';
    }
}
