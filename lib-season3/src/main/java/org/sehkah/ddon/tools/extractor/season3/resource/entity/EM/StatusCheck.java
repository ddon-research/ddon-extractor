package org.sehkah.ddon.tools.extractor.season3.resource.entity.EM;

import java.util.List;

public record StatusCheck(
        int Group,
        int Result,
        long Type,
        List<Float> SystemParam,
        boolean ResultAdd,
        boolean ResultOver,
        boolean TypeReverse
) {
}
