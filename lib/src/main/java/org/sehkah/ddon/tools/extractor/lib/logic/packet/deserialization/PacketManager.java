package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.c2l.C2LLoginReqDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.l2c.L2CLoginResDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.serialization.PacketStringSerializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.lib.common.packet.PacketIdentifier.C2L_LOGIN_REQ;
import static org.sehkah.ddon.tools.extractor.lib.common.packet.PacketIdentifier.L2C_LOGIN_RES;

@Slf4j
@Getter
public class PacketManager {
    private final Set<GamePacket> gamePacketSet;
    private final Map<PacketHeader, GamePacket> gamePacketFileMap;
    private final Serializer<Packet> stringSerializer;

    protected PacketManager(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = PacketStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        gamePacketSet = HashSet.newHashSet(128);
        gamePacketFileMap = HashMap.newHashMap(128);
        setupGamePacketFiles(gamePacketSet);
        for (GamePacket gamePacket : gamePacketSet) {
            gamePacketFileMap.put(gamePacket.getPacketHeader(), gamePacket);
        }
    }

    public static PacketManager get(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        return new PacketManager(preferredSerializationType, shouldSerializeMetaInformation);
    }

    private void setupGamePacketFiles(Set<GamePacket> gamePacketSet) {
        gamePacketSet.add(new GamePacket(new PacketHeader(C2L_LOGIN_REQ, 0, 1, 1, 0x00), C2LLoginReqDeserializer.class));
        gamePacketSet.add(new GamePacket(new PacketHeader(L2C_LOGIN_RES, 0, 1, 2, 0x34), L2CLoginResDeserializer.class));
    }

    public PacketDeserializer<Packet> getDeserializer(FileReader fileReader) {
        PacketHeader identifiedPacketHeader = PacketHeaderDeserializer.parseQuick(fileReader);
        log.debug("Attempting to match parsed packet header '%s' to deserializer.".formatted(identifiedPacketHeader));
        if (gamePacketFileMap.containsKey(identifiedPacketHeader)) {
            PacketDeserializer<Packet> deserializer = gamePacketFileMap.get(identifiedPacketHeader).getDeserializer();
            log.debug("Matched deserializer {}.", deserializer.getClass().getSimpleName());
            return deserializer;
        }
        log.debug("No deserializer matches for packet header '%s'.".formatted(identifiedPacketHeader));
        return null;
    }
}
