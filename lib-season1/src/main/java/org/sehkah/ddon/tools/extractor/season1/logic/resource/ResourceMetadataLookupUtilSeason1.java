package org.sehkah.ddon.tools.extractor.season1.logic.resource;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroupList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.base.StageListInfoList;

import java.nio.file.Path;

@Slf4j
@Setter
public class ResourceMetadataLookupUtilSeason1 extends ResourceMetadataLookupUtil {
    private final ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile;
    private final ClientResourceFile<EnemyGroupList> EnemyGroupListResourceFile;
    private final ClientResourceFile<StageListInfoList> StageListInfoResourceFile;

    public ResourceMetadataLookupUtilSeason1(Path clientRootFolder, Path clientTranslationFile, ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile, ClientResourceFile<EnemyGroupList> EnemyGroupListResourceFile, ClientResourceFile<StageListInfoList> StageListInfoResourceFile) {
        super(clientRootFolder, clientTranslationFile);
        this.NpcLedgerListResourceFile = NpcLedgerListResourceFile;
        this.EnemyGroupListResourceFile = EnemyGroupListResourceFile;
        this.StageListInfoResourceFile = StageListInfoResourceFile;
    }

    @Override
    public Translation getNpcName(long npcId) {
        if (npcId < 1) {
            return null;
        }
        NpcLedgerList list = cache.getResource(ResourceLookupTable.NPC_NLL.getFilePath(), NpcLedgerListResourceFile, this);
        NpcLedgerListItem npc = list.getNpcById(npcId);
        return npc.getNpcName();
    }

    @Override
    public Translation getStageNameByStageNo(int stageNo) {
        if (stageNo <= 0) {
            return null;
        }
        StageListInfoList list = cache.getResource(ResourceLookupTable.STAGE_LIST_SLT.getFilePath(), StageListInfoResourceFile, this);
        StageListInfo stage = list.getStageByStageNo(stageNo);
        if (stage == null) {
            return null;
        }
        return stage.getStageName();
    }

    @Override
    public Translation getStageNameByStageId(int stageId) {
        StageListInfoList list = cache.getResource(ResourceLookupTable.STAGE_LIST_SLT.getFilePath(), StageListInfoResourceFile, this);
        StageListInfo stage = list.getStageByStageId(stageId);
        if (stage == null) {
            return null;
        }
        return stage.getStageName();
    }

    @Override
    public Translation getItemName(long itemId) {
        throw new TechnicalException("TODO");
    }

    @Override
    public Translation getEnemyName(long enemyId) {
        if (enemyId < 65792 || enemyId > 1048838) {
            return null;
        }
        EnemyGroupList list = cache.getResource(ResourceLookupTable.ENEMY_GROUP.getFilePath(), EnemyGroupListResourceFile, this);
        EnemyGroup enemy = list.getEnemyById(enemyId);
        return enemy.getEnemyGroupName();
    }
}
