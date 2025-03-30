package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.Getter;

@Getter
public enum ResourceLookupTable {
    // NLL
    NPC_NLL("npc/npc_common/etc/npc/", "npc.nll"),
    // SLT
    STAGE_LIST_SLT("base/scr/", "stage_list.slt"),
    // IPA
    ITEM_LIST("base/etc/", "itemlist.ipa"),
    // EMG
    ENEMY_GROUP("game_common/param/", "enemy_group.emg"),
    // ARS
    AREA_STAGE_LIST_S2("game_common/scr/", "area_stage_list.ars"),
    AREA_STAGE_LIST_S3("base/scr/", "area_stage_list.ars"),
    ;

    String folderPath;
    String fileName;
    String filePath;

    ResourceLookupTable(String folderPath, String fileName) {
        this.folderPath = folderPath;
        this.fileName = fileName;
        this.filePath = folderPath + fileName;
    }
}
