package org.sehkah.ddon.tools.extractor.season2.logic.resource;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroup;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.EnemyGroupList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerListItem;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.ItemList;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.ItemListItemParam;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.StageListInfo;
import org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.base.StageListInfoList;

import java.nio.file.Path;

@Slf4j
@Setter
public class ResourceMetadataLookupUtilSeason2 extends ResourceMetadataLookupUtil {
    private final ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile;
    private final ClientResourceFile<EnemyGroupList> EnemyGroupListResourceFile;
    private final ClientResourceFile<StageListInfoList> StageListInfoResourceFile;
    private final ClientResourceFile<ItemList> ItemListResourceFile;

    public ResourceMetadataLookupUtilSeason2(Path clientRootFolder, Path clientTranslationFile,
                                             ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile,
                                             ClientResourceFile<EnemyGroupList> EnemyGroupListResourceFile,
                                             ClientResourceFile<StageListInfoList> StageListInfoResourceFile,
                                             ClientResourceFile<ItemList> ItemListResourceFile
    ) {
        super(clientRootFolder, clientTranslationFile);
        this.NpcLedgerListResourceFile = NpcLedgerListResourceFile;
        this.EnemyGroupListResourceFile = EnemyGroupListResourceFile;

        this.StageListInfoResourceFile = StageListInfoResourceFile;
        this.ItemListResourceFile = ItemListResourceFile;
    }

    @Override
    public Translation getNpcName(long npcId) {
        if (npcId < 1) {
            return null;
        }
        NpcLedgerList list = cache.getResource(ResourceLookupTable.NPC_NLL.getFilePath(), NpcLedgerListResourceFile, this);
        NpcLedgerListItem npc = list.getNpcById(npcId);
        if (npc == null) {
            return null;
        }
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
        if (itemId < 34) {
            return null;
        }
        ItemList list = cache.getResource(ResourceLookupTable.ITEM_LIST.getFilePath(), ItemListResourceFile, this);
        ItemListItemParam item = list.getItemById(itemId);
        return item.getItemName();
    }

    @Override
    public Translation getEnemyName(long enemyId) {
        if (enemyId < 65792 || enemyId > 1048838) {
            return null;
        }
        EnemyGroupList list = cache.getResource(ResourceLookupTable.ENEMY_GROUP.getFilePath(), EnemyGroupListResourceFile, this);
        EnemyGroup enemy = list.getEnemyById(enemyId);
        if (enemy == null) {
            return null;
        }
        return enemy.getEnemyGroupName();
    }
}
