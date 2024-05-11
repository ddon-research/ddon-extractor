package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.error.PacketParsingIncompleteException;
import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.GamePacketFile;

public abstract class PacketFileDeserializer implements PacketDeserializer<Packet> {
    private final PacketHeaderDeserializer packetHeaderDeserializer;

    protected PacketFileDeserializer(GamePacketFile gamePacketFile) {
        this.packetHeaderDeserializer = new PacketHeaderDeserializer(gamePacketFile.getPacketHeader());
    }

    @Override
    public Packet deserialize(FileReader fileReader) {
        PacketHeader packetHeader = packetHeaderDeserializer.parse(fileReader);
        Packet packet = parse(fileReader);
        packet.setHeader(packetHeader);
        if (fileReader.hasRemaining()) {
            throw new PacketParsingIncompleteException(packet, fileReader.getRemainingCount(), fileReader.getLimit());
        }
        packet.setSize(fileReader.getLimit());
        return packet;
    }

    protected abstract Packet parse(FileReader fileReader);
}
