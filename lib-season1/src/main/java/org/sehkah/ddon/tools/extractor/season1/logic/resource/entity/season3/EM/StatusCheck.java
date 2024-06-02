package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.season3.EM;

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
