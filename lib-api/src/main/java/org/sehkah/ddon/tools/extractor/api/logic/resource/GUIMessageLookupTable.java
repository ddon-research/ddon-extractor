package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.Getter;

@Getter
public enum GUIMessageLookupTable {
    ABILITY_INFO("ui/uGUIJobMaster/ui/00_message/skill/", "ability_info.gmd"),
    ABILITY_NAME("ui/gui_cmn/ui/00_message/skill/", "ability_name.gmd"),
    ACHIEVEMENT_CATEGORY("ui/uGUIAchievement/ui/00_message/achievement/", "achievement_category.gmd"),
    ACHIEVEMENT_INFO("ui/uGUIAchievement/ui/00_message/achievement/", "achievement_info.gmd"),
    ACHIEVEMENT_NAME("ui/gui_cmn/ui/00_message/achievement/", "achievement_name.gmd"),
    AREA_LIST("ui/gui_cmn/ui/00_message/common/", "area_list.gmd"),
    CLAN_FURNITURE_LAYOUT_NAME("clankyoten/ui/00_message/common/", "clan_furniture_layout_name.gmd"),
    ENEMY_NAME("ui/gui_cmn/ui/00_message/enemy/", "enemy_name.gmd"),
    FIELD_AREA_NAME("game_common/ui/00_message/common/", "field_area_name.gmd"),
    FUNC_SELECT_NAME("game_common/ui/00_message/npc/", "func_select_name.gmd"),
    FURNITURE_GROUP_NAME("MyRoom/ui/00_message/common/", "furniture_group_name.gmd"),
    FURNITURE_LAYOUT_NAME("MyRoom/ui/00_message/common/", "furniture_layout_name.gmd"),
    ITEM_NAME("ui/gui_cmn/ui/00_message/common/", "item_name.gmd"),
    ITEM_INFO("ui/item_info/ui/00_message/common/", "item_info.gmd"),
    LAND_NAME("ui/gui_cmn/ui/00_message/common/", "land_name.gmd"),
    NAMED_PARAM("ui/gui_cmn/ui/00_message/named/", "named_param.gmd"),
    NPC_CLASS_NAME("npc/npc_common/ui/00_message/npc/", "npc_class_name.gmd"),
    NPC_NAME("npc/npc_common/ui/00_message/npc/", "npc_name.gmd"),
    STAGE_LIST("ui/gui_cmn/ui/00_message/common/", "stage_list.gmd"),
    TUTORIAL_GUIDE("tutorial_guide/ui/00_message/tutorial_guide/", "tutorial_guide.gmd"),
    TUTORIAL_GUIDE_CATEGORY("ui/uGUIMenuTutorial/ui/00_message/tutorial_guide/", "tutorial_guide_category.gmd"),
    JOB_NAME("ui/gui_cmn/ui/00_message/common/", "job_name.gmd"),
    SPOT_NAME("ui/gui_cmn/ui/00_message/common/", "spot_name.gmd"),
    SPOT_CATEGORY("ui/uGUIAreaMaster/ui/00_message/master/", "spot_category.gmd"),
    // UNUSED
    EVENT_NAME("EventViewRoom/ui/00_message/event/", "event_name.gmd"),

    ;

    String folderPath;
    String fileName;
    String filePath;

    GUIMessageLookupTable(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;
        this.filePath = folderPath + fileName;
    }
}
