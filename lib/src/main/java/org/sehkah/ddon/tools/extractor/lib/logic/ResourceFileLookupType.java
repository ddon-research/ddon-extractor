package org.sehkah.ddon.tools.extractor.lib.logic;

public enum ResourceFileLookupType {
    // GMD
    ITEM_NAME("ui/gui_cmn/ui/00_message/common/", "item_name.gmd"),
    ENEMY_NAME("ui/gui_cmn/ui/00_message/enemy/", "enemy_name.gmd"),
    AREA_LIST("ui/gui_cmn/ui/00_message/common/", "area_list.gmd"),
    LAND_NAME("ui/gui_cmn/ui/00_message/common/", "land_name.gmd"),
    STAGE_LIST("ui/gui_cmn/ui/00_message/common/", "stage_list.gmd"),
    FIELD_AREA_NAME("game_common/ui/00_message/common/", "field_area_name.gmd"),
    FUNC_SELECT_NAME("game_common/ui/00_message/npc/", "func_select_name.gmd"),
    FUNC_CLASS_NAME("ui/gui_cmn/ui/00_message/npc/", "func_class_name.gmd"),
    NPC_NAME("npc/npc_common/ui/00_message/npc/", "npc_name.gmd"),
    NPC_CLASS_NAME("npc/npc_common/ui/00_message/npc/", "npc_class_name.gmd"),
    FURNITURE_GROUP_NAME("MyRoom/ui/00_message/common/", "furniture_group_name.gmd"),
    FURNITURE_LAYOUT_NAME("MyRoom/ui/00_message/common/", "furniture_layout_name.gmd"),
    CLAN_FURNITURE_LAYOUT_NAME("clankyoten/ui/00_message/common", "clan_furniture_layout_name.gmd"),
    TUTORIAL_GUIDE("tutorial_guide/ui/00_message/tutorial_guide/", "tutorial_guide.gmd"),
    TUTORIAL_GUIDE_CATEGORY("ui/uGUIMenuTutorial/ui/00_message/tutorial_guide/", "tutorial_guide_category.gmd"),
    ABILITY_NAME("ui/gui_cmn/ui/00_message/skill", "ability_name.gmd"),
    ABILITY_INFO("ui/uGUIJobMaster/ui/00_message/skill", "ability_info.gmd"),
    ACHIEVEMENT_NAME("ui/gui_cmn/ui/00_message/achievement", "achievement_name.gmd"),
    ACHIEVEMENT_INFO("ui/uGUIAchievement/ui/00_message/achievement", "achievement_info.gmd"),
    ACHIEVEMENT_CATEGORY("ui/uGUIAchievement/ui/00_message/achievement", "achievement_category.gmd"),
    EVENT_NAME("EventViewRoom/ui/00_message/event", "event_name.gmd"),
    // NLL
    NPC_NLL("npc/npc_common/etc/npc/", "npc.nll"),
    // SLT
    STAGE_LIST_SLT("base/scr/", "stage_list.slt"),
    ;

    String folderPath;
    String fileName;

    ResourceFileLookupType(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;
    }
}
