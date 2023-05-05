package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

import org.sehkah.doon.tools.extractor.lib.logic.deserialization.base.*;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.game_common.EnemyGroupDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.StageMapDeserializer;
import org.sehkah.doon.tools.extractor.lib.logic.deserialization.gui_cmn.WarpLocationDeserializer;

import java.util.Arrays;

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
    SG_TBL("sg_tbl", null, 257, StatusGainTableDeserializer.class),
    UNSUPPORTED("", null, 0, null);

    static {
        System.out.println((Arrays.toString(ExtensionMap.values())));
    }

    public final String fileExtension;
    public final String magic;
    public final long version;
    public final Class<? extends Deserializer> deserializer;

    ExtensionMap(String fileExtension, String magic, long version, Class<? extends Deserializer> deserializer) {
        this.fileExtension = fileExtension;
        this.magic = magic;
        this.version = version;
        this.deserializer = deserializer;
    }

    public static ExtensionMap findByFileExtension(String filePath) {
        for (ExtensionMap value : ExtensionMap.values()) {
            if (filePath.endsWith(value.fileExtension)) {
                return value;
            }
        }
        return UNSUPPORTED;
    }

    @Override
    public String toString() {
        return "{\n\"fileExtension\": \"" + fileExtension + "\",\n"
                + (magic != null ? "\"magic\": \"" + magic + "\",\n" : "")
                + "\"version\": " + version + "\n}";
    }
}
