package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.EnemyGroupDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.StageMapDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.WarpLocationDeserializer;

public enum ExtensionMap {
    EMG("emg", null, 1, EnemyGroupDeserializer.class),
    WAL("wal", null, 353, WarpLocationDeserializer.class),
    SMP("smp", null, 1, StageMapDeserializer.class),
    LAI("lai", "LAI\0", 4, LandAreaInfoDeserializer.class),
    ARS("ars", "ARS\0", 2, AreaInfoStageDeserializer.class),
    ARI("ari", "ARI\0", 2, AreaInfoDeserializer.class),
    SLT("slt", "slt\0", 34, StageInfoDeserializer.class),
    EVP("evp", null, 19, EventListDeserializer.class),
    JOBBASE("jobbase", null, 263, JobBaseParamDeserializer.class),
    AJP("ajp", null, 256, JobAdjustParamDeserializer.class),
    JLT2("jlt2", null, 1, JobLevelUpTableDeserializer.class),
    UNSUPPORTED("", null, 0, null);

    public final String resourceFileExtension;
    public final String magic;
    public final long version;
    public final Class<? extends Deserializer> deserializer;

    ExtensionMap(String resourceFileExtension, String magic, long version, Class<? extends Deserializer> deserializer) {
        this.resourceFileExtension = resourceFileExtension;
        this.magic = magic;
        this.version = version;
        this.deserializer = deserializer;
    }

    /**
     * This method matches on the file extension at the end of the path and ensures the arc file path is contained as well.
     * This avoids issues when the resource file name is different but the extraction uses the same deserializer.
     */
    public static ExtensionMap findByFileExtension(String filePath) {
        for (ExtensionMap value : ExtensionMap.values()) {
            if (filePath.endsWith(value.resourceFileExtension)) {
                return value;
            }
        }
        return UNSUPPORTED;
    }

    @Override
    public String toString() {
        return "ExtensionMap{" +
                "resourceFileExtension='" + resourceFileExtension + '\'' +
                ", magic='" + magic + '\'' +
                ", version=" + version +
                ", deserializer=" + deserializer +
                '}';
    }
}
