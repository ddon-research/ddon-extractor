package org.sehkah.ddon.tools.extractor.season2.logic.resource;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.StageListInfoList;

import java.nio.file.Path;

@Slf4j
@Setter
public class ResourceMetadataLookupUtilSeason2 extends ResourceMetadataLookupUtil {
    private final ClientResourceFile<GUIMessage> GUIMessageResourceFile;
    private final ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile;
    private final ClientResourceFile<StageListInfoList> StageListInfoResourceFile;

    public ResourceMetadataLookupUtilSeason2(Path clientRootFolder, Path clientTranslationFile, ClientResourceFile<GUIMessage> GUIMessageResourceFile, ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile, ClientResourceFile<StageListInfoList> StageListInfoResourceFile) {
        super(clientRootFolder, clientTranslationFile);
        this.GUIMessageResourceFile = GUIMessageResourceFile;
        this.NpcLedgerListResourceFile = NpcLedgerListResourceFile;
        this.StageListInfoResourceFile = StageListInfoResourceFile;
    }

    @Override
    public Translation getNpcName(long npcId) {
        NpcLedgerList list = cache.getResource(ResourceLookupTable.NPC_NLL.getFilePath(), NpcLedgerListResourceFile, this);
        NpcLedgerListItem npc = list.getNpcById(npcId);
        return npc.getNpcName();
    }

    @Override
    public Translation getStageNameByStageNo(int stageNo) {
        StageListInfoList list = cache.getResource(ResourceLookupTable.STAGE_LIST_SLT.getFilePath(), StageListInfoResourceFile, this);
        StageListInfo stage = list.getStageByStageNo(stageNo);
        return stage.getStageName();
    }

    @Override
    public Translation getStageNameByStageId(int stageId) {
        StageListInfoList list = cache.getResource(ResourceLookupTable.STAGE_LIST_SLT.getFilePath(), StageListInfoResourceFile, this);
        StageListInfo stage = list.getStageByStageId(stageId);
        return stage.getStageName();
    }
}
