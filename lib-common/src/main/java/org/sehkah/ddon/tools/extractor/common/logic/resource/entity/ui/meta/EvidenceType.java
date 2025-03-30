package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.ui.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum EvidenceType {
    NONE(0),
    WEAPON(1),
    DOCUMENT(2),
    SCROLL(3),
    NECKLACE(4),
    PAINTING(5),
    POSTER(6);

    private static final Map<Integer, EvidenceType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(EvidenceType::ordinal, Function.identity()));
    public final long value;

    EvidenceType(long value) {
        this.value = value;
    }

    public static EvidenceType of(Integer n) {
        return ordinalMap.get(n);
    }
}
