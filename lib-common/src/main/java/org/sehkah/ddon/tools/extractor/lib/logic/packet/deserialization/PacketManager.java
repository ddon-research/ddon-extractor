package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.Serializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.serialization.PacketStringSerializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
public abstract class PacketManager {
    protected final Set<GamePacket> gamePacketSet;
    protected final Map<PacketHeader, GamePacket> gamePacketFileMap;
    protected final Serializer<Packet> stringSerializer;

    protected PacketManager(SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        stringSerializer = PacketStringSerializer.get(preferredSerializationType, shouldSerializeMetaInformation);
        gamePacketSet = HashSet.newHashSet(128);
        gamePacketFileMap = HashMap.newHashMap(128);

        setup(gamePacketSet);

        for (GamePacket gamePacket : gamePacketSet) {
            gamePacketFileMap.put(gamePacket.getPacketHeader(), gamePacket);
        }
    }

    public abstract void setup(Set<GamePacket> clientResourceFileSet);

    public PacketBufferDeserializer<Packet> getDeserializer(BufferReader bufferReader) {
        PacketHeader identifiedPacketHeader = PacketHeaderDeserializer.parseQuick(bufferReader);
        log.debug("Attempting to match parsed packet header '%s' to deserializer.".formatted(identifiedPacketHeader));
        if (gamePacketFileMap.containsKey(identifiedPacketHeader)) {
            PacketBufferDeserializer<Packet> deserializer = gamePacketFileMap.get(identifiedPacketHeader).getDeserializer();
            log.debug("Matched deserializer {}.", deserializer.getClass().getSimpleName());
            return deserializer;
        }
        log.debug("No deserializer matches for packet header '%s'.".formatted(identifiedPacketHeader));
        return null;
    }
}
