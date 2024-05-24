package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;
import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class NpcLedgerList extends TopLevelClientResource {
    private final List<NpcLedgerListItem> NpcLedgerList;

    public NpcLedgerListItem getNpcById(long npcId) {
        return getNpcByIdNaive(npcId);
    }

    private NpcLedgerListItem getNpcByIdNaive(long npcId) {
        Optional<NpcLedgerListItem> optionalIndex = NpcLedgerList.stream().filter(i -> i.NpcId() == npcId).findFirst();
        return optionalIndex.orElse(null);
    }
}
