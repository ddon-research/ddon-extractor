package org.sehkah.doon.tools.extractor.lib.logic.deserialization;

public enum ResourceMap {
    ENEMY_GROUP("game_common/param", "enemy_group", ExtensionMap.EMG),
    WARP_LOCATION("ui/gui_cmn/ui/03_warp", "warpLocationList", ExtensionMap.WAL),
    STAGE_MAP("ui/gui_cmn/param", "stage_map", ExtensionMap.SMP),
    LOBBY_WARP_LOCATION("ui/uGUIRimWarp/ui/03_warp", "lobbyWarpLocationList", ExtensionMap.WAL),
    LAND_AREA_INFO("base/scr", "land_list", ExtensionMap.LAI),
    AREA_INFO_STAGE("base/scr", "area_stage_list", ExtensionMap.ARS),
    AREA_INFO("base/scr", "area_list", ExtensionMap.ARI),
    STAGE_INFO("base/scr", "stage_list", ExtensionMap.SLT),
    EVENT_PARAM("base/event", "event_list", ExtensionMap.EVP),
    JOB_BASE_PARAM("base/obj/pl/pl000000/param/jobleveluptbl", "base", ExtensionMap.JOBBASE),
    JOB_ADJUST_PARAM("base/obj/pl/pl000000/param/jobleveluptbl", "baseStatus", ExtensionMap.AJP),
    JOB_LEVEL_UP_TABLE_JOB1("base/obj/pl/pl000000/param/jobleveluptbl", "job01", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB2("base/obj/pl/pl000000/param/jobleveluptbl", "job02", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB3("base/obj/pl/pl000000/param/jobleveluptbl", "job03", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB4("base/obj/pl/pl000000/param/jobleveluptbl", "job04", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB5("base/obj/pl/pl000000/param/jobleveluptbl", "job05", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB6("base/obj/pl/pl000000/param/jobleveluptbl", "job06", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB7("base/obj/pl/pl000000/param/jobleveluptbl", "job07", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB8("base/obj/pl/pl000000/param/jobleveluptbl", "job08", ExtensionMap.JLT2),
    JOB_LEVEL_UP_TABLE_JOB9("base/obj/pl/pl000000/param/jobleveluptbl", "job09", ExtensionMap.JLT2),

    UNSUPPORTED("", "", ExtensionMap.UNSUPPORTED);

    public final String arcFilePath;
    public final String resourceFileName;
    public final ExtensionMap resourceFileExtension;

    ResourceMap(String arcFilePath, String resourceFileName, ExtensionMap extension) {
        this.arcFilePath = arcFilePath;
        this.resourceFileName = resourceFileName;
        this.resourceFileExtension = extension;
    }

    @Override
    public String toString() {
        return "ResourceMap{" +
                "arcFilePath='" + arcFilePath + '\'' +
                ", resourceFileName='" + resourceFileName + '\'' +
                ", resourceFileExtension=" + resourceFileExtension +
                '}';
    }
}
