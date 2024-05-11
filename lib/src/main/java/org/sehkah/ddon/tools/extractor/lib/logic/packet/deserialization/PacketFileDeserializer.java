package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;

@Slf4j
public abstract class PacketFileDeserializer implements PacketDeserializer<Packet> {
    private final PacketHeaderDeserializer packetHeaderDeserializer;

    protected PacketFileDeserializer(GamePacket gamePacket) {
        this.packetHeaderDeserializer = new PacketHeaderDeserializer(gamePacket.getPacketHeader());
    }

    @Override
    public Packet deserialize(FileReader fileReader) {
        PacketHeader packetHeader = packetHeaderDeserializer.parse(fileReader);
        Packet packet = parse(fileReader);
        packet.setHeader(packetHeader);
        packet.setSize(fileReader.getLimit());
        packet.setDataSize(fileReader.getPosition());
        log.debug("Assuming {} bytes of padding, skipping reading.", fileReader.getRemainingCount());
        fileReader.setPosition(fileReader.getLimit());
//        if (fileReader.hasRemaining()) {
//            throw new PacketParsingIncompleteException(packet, fileReader.getRemainingCount(), fileReader.getLimit());
//        }
        return packet;
    }

    protected abstract Packet parse(FileReader fileReader);
}
