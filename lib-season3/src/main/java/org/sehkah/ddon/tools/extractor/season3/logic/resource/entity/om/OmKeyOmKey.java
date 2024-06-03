package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.om;

import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

public record OmKeyOmKey(
        int OmId,
        long KeyType,
        Vector3f Pos,
        boolean Horizontal
) {

}
