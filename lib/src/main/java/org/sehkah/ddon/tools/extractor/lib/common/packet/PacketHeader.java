package org.sehkah.ddon.tools.extractor.lib.common.packet;

import lombok.Getter;
import lombok.Setter;
import org.sehkah.ddon.tools.extractor.lib.common.packet.meta.PacketGroup;
import org.sehkah.ddon.tools.extractor.lib.common.packet.meta.PacketSubType;
import org.sehkah.ddon.tools.extractor.lib.common.packet.meta.PacketType;

import java.util.Arrays;
import java.util.function.Predicate;

@Getter

public enum PacketHeader {
    C2L_LOGIN_REQ(0, 1, 1, 0x00),
    L2C_LOGIN_RES(0, 1, 2, 0x34);


    private static final PacketHeader[] values = values();
    private final int group;
    private final int id;
    private final int subId;
    private final int source;
    private final PacketGroup packetGroup;
    private final PacketSubType packetSubType;
    private final PacketType packetType;
    @Setter
    private long count;

    PacketHeader(int group, int id, int subId, int source) {
        this.group = group;
        this.packetGroup = PacketGroup.of(group);

        this.id = id;

        this.subId = subId;
        this.packetSubType = PacketSubType.of(subId);
        this.packetType = switch (packetSubType) {
            case REQ -> packetGroup == PacketGroup.CONNECTION ? PacketType.C2L : PacketType.C2S;
            case RES, NTC -> packetGroup == PacketGroup.CONNECTION ? PacketType.L2C : PacketType.S2C;
            case UNKNOWN -> PacketType.UNKNOWN;
        };

        this.source = source;
        this.count = 0;
    }

    public static PacketHeader of(int group, int id, int subId, int source) {
        return Arrays.stream(values).filter(packetHeaderEquals(group, id, subId, source)).findFirst().orElse(null);
    }

    private static Predicate<PacketHeader> packetHeaderEquals(int group, int id, int subId, int source) {
        return h -> h.getGroup() == group && h.getId() == id && h.getSubId() == subId && h.getSource() == source;
    }

    public static boolean equals(PacketHeader packetHeader1, PacketHeader packetHeader2) {
        return packetHeaderEquals(packetHeader1.group, packetHeader1.id, packetHeader1.subId, packetHeader1.source).test(packetHeader2);
    }

    public static boolean equals(int group, int id, int subId, int source, PacketHeader packetHeader2) {
        return packetHeaderEquals(group, id, subId, source).test(packetHeader2);
    }
}
