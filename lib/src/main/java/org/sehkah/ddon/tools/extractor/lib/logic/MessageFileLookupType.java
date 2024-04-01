package org.sehkah.ddon.tools.extractor.lib.logic;

public enum MessageFileLookupType {
    ITEM_NAME("ui/gui_cmn/ui/00_message/common/", "item_name"),
    ENEMY_NAME("ui/gui_cmn/ui/00_message/enemy/", "enemy_name"),
    AREA_LIST("ui/gui_cmn/ui/00_message/common/", "area_list"),
    LAND_NAME("ui/gui_cmn/ui/00_message/common/", "land_name"),
    FIELD_AREA_NAME("game_common/ui/00_message/common/", "field_area_name"),
    FUNC_SELECT_NAME("game_common/ui/00_message/npc/", "func_select_name"),

    ;

    String folderPath;
    String fileName;

    MessageFileLookupType(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;
    }
}
