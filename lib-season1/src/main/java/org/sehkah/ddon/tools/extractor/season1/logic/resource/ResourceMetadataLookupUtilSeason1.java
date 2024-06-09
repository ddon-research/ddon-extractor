package org.sehkah.ddon.tools.extractor.season1.logic.resource;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ClientResourceFile;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceLookupTable;
import org.sehkah.ddon.tools.extractor.api.logic.resource.ResourceMetadataLookupUtil;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common.GUIMessage;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common.NpcLedgerList;

import java.nio.file.Path;

@Slf4j
@Setter
public class ResourceMetadataLookupUtilSeason1 extends ResourceMetadataLookupUtil {
    private final ClientResourceFile<GUIMessage> GUIMessageResourceFile;
    private final ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile;

    public ResourceMetadataLookupUtilSeason1(Path clientRootFolder, ClientResourceFile<GUIMessage> GUIMessageResourceFile, ClientResourceFile<NpcLedgerList> NpcLedgerListResourceFile) {
        super(clientRootFolder);
        this.GUIMessageResourceFile = GUIMessageResourceFile;
        this.NpcLedgerListResourceFile = NpcLedgerListResourceFile;
    }

    @Override
    public String getMessage(String filePath, long messageIndex) {
        GUIMessage resource = cache.getResource(filePath, GUIMessageResourceFile);
        return resource.getMessageByIndex(messageIndex);
    }

    @Override
    public String getMessageKey(String filePath, long messageIndex) {
        GUIMessage resource = cache.getResource(filePath, GUIMessageResourceFile);
        return resource.getMessageKeyByIndex(messageIndex);
    }

    @Override
    public String getMessage(String filePath, String key) {
        GUIMessage resource = cache.getResource(filePath, GUIMessageResourceFile);
        return resource.getMessageByKey(key);
    }

    @Override
    public String getNpcName(long npcId) {
        NpcLedgerList npcLedgerList = cache.getResource(ResourceLookupTable.NPC_NLL.getFilePath(), NpcLedgerListResourceFile, this);
        return npcLedgerList.getNpcById(npcId).getNpcName();
    }
}
