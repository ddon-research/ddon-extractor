package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.LandInfoDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.EnemyGroupDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.WarpLocationListDeserializer;

import java.nio.file.Path;
import java.util.Arrays;

public enum ExtractionType {
    ENEMY_GROUP("game_common", "param", "enemy_group.emg", "emg", null, EnemyGroupDeserializer.INSTANCE),
    WARP_LOCATION_LIST("ui/gui_cmn", "ui/03_warp", "warpLocationList.wal", "wal", null, WarpLocationListDeserializer.INSTANCE),
    LOBBY_WARP_LOCATION_LIST("ui/uGUIRimWarp", "ui/03_warp", "lobbyWarpLocationList.wal", "wal", null, WarpLocationListDeserializer.INSTANCE),
    LAND_INFO("base", "scr", "land_list.lai", "lai", "LAI ", LandInfoDeserializer.INSTANCE),
    UNSUPPORTED("", "", "", "", null, null);

    public final String arcFile;
    public final String arcFilePath;
    public final String resourceFileName;
    public final String resourceFileExtension;
    public final String magic;
    public final Deserializer deserializer;

    ExtractionType(String arcFile, String arcFilePath, String resourceFileName, String resourceFileExtension, String magic, Deserializer deserializer) {
        this.arcFile = arcFile;
        this.arcFilePath = arcFilePath;
        this.resourceFileName = resourceFileName;
        this.resourceFileExtension = resourceFileExtension;
        this.magic = magic;
        this.deserializer = deserializer;
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

    public String toFilePath() {
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
