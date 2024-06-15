package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.npc_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;
import java.util.Optional;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class NpcLedgerList extends Resource {
    private List<NpcLedgerListItem> NpcLedgerList;

    public NpcLedgerListItem getNpcById(long npcId) {
        return getNpcByIdNaive(npcId);
    }

    private NpcLedgerListItem getNpcByIdNaive(long npcId) {
        Optional<NpcLedgerListItem> optionalIndex = NpcLedgerList.stream().filter(i -> i.getNpcId() == npcId).findFirst();
        return optionalIndex.orElse(null);
    }
}
