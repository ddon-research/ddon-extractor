package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.lib.common.entity.TopLevelClientResource;

import java.util.List;
import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcLedgerList extends TopLevelClientResource {
    private List<NpcLedgerListItem> NpcLedgerList;

    public NpcLedgerListItem getNpcById(long npcId) {
        return getNpcByIdNaive(npcId);
    }

    private NpcLedgerListItem getNpcByIdNaive(long npcId) {
        Optional<NpcLedgerListItem> optionalIndex = NpcLedgerList.stream().filter(i -> i.getNpcId() == npcId).findFirst();
        return optionalIndex.orElse(null);
    }
}
