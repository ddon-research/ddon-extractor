package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.error.PacketParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacket;

@Slf4j
public abstract class PacketFileBufferDeserializer implements PacketBufferDeserializer<Packet> {
    private final PacketHeaderDeserializer packetHeaderDeserializer;

    protected PacketFileBufferDeserializer(GamePacket gamePacket) {
        this.packetHeaderDeserializer = new PacketHeaderDeserializer(gamePacket.getPacketHeader());
    }

    // TODO: Support multi-packets
    // TODO: Support multi pcaps
    // TODO: Support YAML
    @Override
    public Packet deserialize(BufferReader bufferReader) {
        PacketHeader packetHeader = packetHeaderDeserializer.parse(bufferReader);
        Packet packet = parse(bufferReader);
        packet.setHeader(packetHeader);
        packet.setSize(bufferReader.getLimit());
        packet.setDataSize(bufferReader.getPosition());
        if (bufferReader.hasRemaining() && bufferReader.getRemainingCount() < 16) {
            log.debug("Assuming {} bytes of padding, skipping reading.", bufferReader.getRemainingCount());
            bufferReader.setPosition(bufferReader.getLimit());
        } else {
            throw new PacketParsingIncompleteException(packet, bufferReader.getRemainingCount(), bufferReader.getLimit());
        }
        return packet;
    }

    protected abstract Packet parse(BufferReader bufferReader);
}
