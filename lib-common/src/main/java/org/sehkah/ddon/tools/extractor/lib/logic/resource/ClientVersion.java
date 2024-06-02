package org.sehkah.ddon.tools.extractor.lib.logic.resource;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum ClientVersion {
    VERSION_1_1(1, 1),
    VERSION_2_3(2, 3),
    VERSION_3_4(3, 4);

    private static final Map<Pair<Integer, Integer>, ClientVersion> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> Pair.of(e.major, e.minor), Function.identity()));
    private final int major;
    private final int minor;

    ClientVersion(final int major, final int minor) {
        this.major = major;
        this.minor = minor;
    }

    public static ClientVersion of(Integer major, Integer minor) {
        return ordinalMap.getOrDefault(Pair.of(major, minor), VERSION_3_4);
    }
}
