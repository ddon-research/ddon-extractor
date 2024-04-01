package org.sehkah.ddon.tools.extractor.lib.logic;

public enum MessageFileLookupType {
    ITEM_NAME("ui/gui_cmn/ui/00_message/common/", "item_name"),
    ENEMY_NAME("ui/gui_cmn/ui/00_message/enemy/", "enemy_name"),
    AREA_LIST("ui/gui_cmn/ui/00_message/common/", "area_list"),
    LAND_NAME("ui/gui_cmn/ui/00_message/common/", "land_name"),
    FIELD_AREA_NAME("game_common/ui/00_message/common/", "field_area_name"),
    FUNC_SELECT_NAME("game_common/ui/00_message/npc/", "func_select_name"),
    FUNC_CLASS_NAME("ui/gui_cmn/ui/00_message/npc/", "func_class_name"),
    NPC_NAME("npc/npc_common/ui/00_message/npc/", "npc_name"),
    NPC_CLASS_NAME("npc/npc_common/ui/00_message/npc/", "npc_class_name"),
    FURNITURE_GROUP_NAME("MyRoom/ui/00_message/common/", "furniture_group_name"),
    FURNITURE_LAYOUT_NAME("MyRoom/ui/00_message/common/", "furniture_layout_name"),
    TUTORIAL_GUIDE("tutorial_guide/ui/00_message/tutorial_guide/", "tutorial_guide"),
    ABILITY_NAME("ui/gui_cmn/ui/00_message/skill", "ability_name"),
    ABILITY_INFO("ui/uGUIJobMaster/ui/00_message/skill", "ability_info"),
    ACHIEVEMENT_NAME("ui/gui_cmn/ui/00_message/achievement", "achievement_name"),
    ACHIEVEMENT_INFO("ui/uGUIAchievement/ui/00_message/achievement", "achievement_info"),
    ACHIEVEMENT_CATEGORY("ui/uGUIAchievement/ui/00_message/achievement", "achievement_category"),
    ;

    String folderPath;
    String fileName;

    MessageFileLookupType(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;
    }
}
