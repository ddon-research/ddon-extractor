package org.sehkah.ddon.tools.extractor.api.packet;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.api.packet.meta.PacketGroup;
import org.sehkah.ddon.tools.extractor.api.packet.meta.PacketSubType;
import org.sehkah.ddon.tools.extractor.api.packet.meta.PacketType;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

import java.util.Objects;
import java.util.function.Predicate;

@ToString
@RequiredArgsConstructor
@Getter
public class PacketHeader {
    private final int group;
    private final int id;
    private final int subId;
    private final int source;
    @MetaInformation
    private final PacketGroup packetGroup;
    @MetaInformation
    private final PacketSubType packetSubType;
    @MetaInformation
    private final PacketType packetType;
    @Setter
    @MetaInformation
    private PacketIdentifier identifier;
    @Setter
    private long count;

    public PacketHeader(PacketIdentifier identifier, int group, int id, int subId, int source) {
        this(group, id, subId, source);
        this.identifier = identifier;
    }

    public PacketHeader(int group, int id, int subId, int source) {
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

    private static Predicate<PacketHeader> packetHeaderEquals(int group, int id, int subId, int source) {
        return h -> h.getGroup() == group && h.getId() == id && h.getSubId() == subId && h.getSource() == source;
    }

    public static boolean equals(PacketHeader packetHeader1, PacketHeader packetHeader2) {
        return packetHeaderEquals(packetHeader1.group, packetHeader1.id, packetHeader1.subId, packetHeader1.source).test(packetHeader2);
    }

    public static boolean equals(int group, int id, int subId, int source, PacketHeader packetHeader2) {
        return packetHeaderEquals(group, id, subId, source).test(packetHeader2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacketHeader that)) return false;
        return group == that.group && id == that.id && subId == that.subId && source == that.source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, id, subId, source);
    }
}
