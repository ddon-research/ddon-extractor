package org.sehkah.ddon.tools.extractor.season3.logic.packet;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.SerializationFormat;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketManager;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.deserialization.c2l.C2LLoginReqBufferDeserializer;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.deserialization.l2c.L2CLoginResBufferDeserializer;
import org.sehkah.ddon.tools.extractor.season3.resource.DynamicResourceLookupUtil;

import java.nio.file.Path;
import java.util.Set;

import static org.sehkah.ddon.tools.extractor.lib.common.packet.PacketIdentifier.C2L_LOGIN_REQ;
import static org.sehkah.ddon.tools.extractor.lib.common.packet.PacketIdentifier.L2C_LOGIN_RES;

@Slf4j
@Getter
public class PacketManagerSeason3 extends PacketManager {
    public PacketManagerSeason3(Path clientRootFolder, SerializationFormat preferredSerializationType, boolean shouldSerializeMetaInformation) {
        super(preferredSerializationType, shouldSerializeMetaInformation);
        DynamicResourceLookupUtil.initialize(clientRootFolder);
    }

    @Override
    public void setup(Set<GamePacket> gamePacketSet) {
        gamePacketSet.add(new GamePacket(new PacketHeader(C2L_LOGIN_REQ, 0, 1, 1, 0x00), C2LLoginReqBufferDeserializer.class));
        gamePacketSet.add(new GamePacket(new PacketHeader(L2C_LOGIN_RES, 0, 1, 2, 0x34), L2CLoginResBufferDeserializer.class));
    }
}
