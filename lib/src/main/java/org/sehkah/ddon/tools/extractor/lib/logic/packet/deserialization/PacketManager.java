package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacketFile;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.c2l.C2LLoginReqDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.l2c.L2CLoginResDeserializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Getter
public class PacketManager {
    private final Set<GamePacketFile> gamePacketFileSet;
    private final Map<PacketHeader, GamePacketFile> gamePacketFileMap;

    public PacketManager() {
        gamePacketFileSet = HashSet.newHashSet(128);
        gamePacketFileMap = HashMap.newHashMap(128);
        setupGamePacketFiles(gamePacketFileSet);
        for (GamePacketFile gamePacketFile : gamePacketFileSet) {
            gamePacketFileMap.put(gamePacketFile.getPacketHeader(), gamePacketFile);
        }
    }

    public static PacketManager get() {
        return new PacketManager();
    }

    private void setupGamePacketFiles(Set<GamePacketFile> gamePacketFileSet) {
        gamePacketFileSet.add(new GamePacketFile(PacketHeader.C2L_LOGIN_REQ, C2LLoginReqDeserializer.class));
        gamePacketFileSet.add(new GamePacketFile(PacketHeader.L2C_LOGIN_RES, L2CLoginResDeserializer.class));
    }

    public PacketDeserializer<Packet> getDeserializer(FileReader fileReader) {
        PacketHeader identifiedPacketHeader = PacketHeaderDeserializer.parseOptimistic(fileReader);
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
