package org.sehkah.ddon.tools.extractor.api.logic.resource;

import lombok.Getter;

@Getter
public enum ResourceLookupTable {
    // NLL
    NPC_NLL("npc/npc_common/etc/npc/", "npc.nll"),
    // SLT
    STAGE_LIST_SLT("base/scr/", "stage_list.slt"),
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
