package org.sehkah.ddon.tools.extractor.model;

import java.nio.file.Path;
import java.util.Arrays;

public enum SupportedExtractionTypes {
    ENEMY_GROUP("game_common", "param", "enemy_group.emg", "emg"),
    UNSUPPORTED("", "", "", "");

    final String arcFile;
    final String arcFilePath;
    final String resourceFileName;
    final String resourceFileExtension;
    SupportedExtractionTypes(String arcFile, String arcFilePath, String resourceFileName, String resourceFileExtension) {
        this.arcFile = arcFile;
        this.arcFilePath = arcFilePath;
        this.resourceFileName = resourceFileName;
        this.resourceFileExtension = resourceFileExtension;
    }

    public static SupportedExtractionTypes findByResourceFileName(String resourceFileName) {
        return Arrays.stream(SupportedExtractionTypes.values()).filter(value -> value.resourceFileName.equals(resourceFileName)).findFirst().orElse(UNSUPPORTED);
    }
    public static SupportedExtractionTypes findByFilePath(Path filePath) {
        for (SupportedExtractionTypes value : SupportedExtractionTypes.values()) {
            if (filePath.toString().replaceAll("\\\\", "/").endsWith(value.toFilePath())) {
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
