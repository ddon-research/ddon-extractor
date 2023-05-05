package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.EnemyGroupDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.StageMapDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.WarpLocationDeserializer;

import java.nio.file.Path;
import java.util.Arrays;

public enum ExtractionType {
    ENEMY_GROUP("game_common", "param", "enemy_group.emg", "emg", null, 1, EnemyGroupDeserializer.class),
    WARP_LOCATION("ui/gui_cmn", "ui/03_warp", "warpLocationList.wal", "wal", null, 353, WarpLocationDeserializer.class),
    STAGE_MAP("ui/gui_cmn", "param", "stage_map.smp", "smp", null, 1, StageMapDeserializer.class),
    LOBBY_WARP_LOCATION("ui/uGUIRimWarp", "ui/03_warp", "lobbyWarpLocationList.wal", "wal", null, 353, WarpLocationDeserializer.class),
    LAND_AREA_INFO("base", "scr", "land_list.lai", "lai", "LAI\0", 4, LandAreaInfoDeserializer.class),
    AREA_INFO_STAGE("base", "scr", "area_stage_list.ars", "ars", "ARS\0", 2, AreaInfoStageDeserializer.class),
    AREA_INFO("base", "scr", "area_list.ari", "ari", "ARI\0", 2, AreaInfoDeserializer.class),
    STAGE_INFO("base", "scr", "stage_list.slt", "slt", "slt\0", 34, StageInfoDeserializer.class),
    EVENT_PARAM("base", "event", "event_list.evp", "evp", null, 19, EventListDeserializer.class),
    UNSUPPORTED("", "", "", "", null, 0, null);

    public final String arcFile;
    public final String arcFilePath;
    public final String resourceFileName;
    public final String resourceFileExtension;
    public final String magic;
    public final long version;
    public final Class<? extends Deserializer> deserializer;

    ExtractionType(String arcFile, String arcFilePath, String resourceFileName, String resourceFileExtension,
                   String magic, long version, Class<? extends Deserializer> deserializer) {
        this.arcFile = arcFile;
        this.arcFilePath = arcFilePath;
        this.resourceFileName = resourceFileName;
        this.resourceFileExtension = resourceFileExtension;
        this.magic = magic;
        this.version = version;
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
