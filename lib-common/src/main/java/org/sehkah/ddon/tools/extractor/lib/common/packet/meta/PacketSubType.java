package org.sehkah.ddon.tools.extractor.lib.common.packet.meta;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PacketSubType {
    REQ(0x1),
    RES(0x2),
    NTC(0xF),
    UNKNOWN(0xFF);

    private static final Map<Integer, PacketSubType> ordinalMap = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, Function.identity()));
    private final int value;

    PacketSubType(final int value) {
        this.value = value;
    }

    public static PacketSubType of(Integer n) {
        return ordinalMap.getOrDefault(n, UNKNOWN);
    }
}
