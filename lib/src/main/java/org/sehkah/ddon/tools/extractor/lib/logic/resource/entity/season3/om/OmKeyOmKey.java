package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season3.om;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record OmKeyOmKey(
        int OmId,
        long KeyType,
        Vector3f Pos,
        boolean Horizontal
) {

}
