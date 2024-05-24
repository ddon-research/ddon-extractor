package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddon.tools.extractor.lib.common.error.PacketHeaderValidationFailedException;
import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.meta.PacketGroup;
import org.sehkah.ddon.tools.extractor.lib.common.packet.meta.PacketSubType;

@Slf4j
public class PacketHeaderDeserializer {
    private final PacketHeader expectedPacketHeader;

    public PacketHeaderDeserializer(PacketHeader packetHeader) {
        this.expectedPacketHeader = packetHeader;
    }

    private static boolean isGroupValid(int encounteredGroup, PacketHeader expectedPacketHeader) throws PacketHeaderValidationFailedException {
        PacketGroup resolvedGroup = PacketGroup.of(encounteredGroup);
        if (resolvedGroup == null) {
            log.error("Encountered group value '{}' is unknown.", encounteredGroup);
            return false;
        }
        if (resolvedGroup != expectedPacketHeader.getPacketGroup()) {
            log.error("Encountered group value '{}' does not equal expected '{}'.", resolvedGroup, expectedPacketHeader.getPacketGroup());
            return false;
        }
        return true;
    }

    private static boolean isIdValid(int encounteredId, PacketHeader expectedPacketHeader) throws PacketHeaderValidationFailedException {
        if (encounteredId < 0 || encounteredId > 127) {
            log.error("Encountered packet ID '{}' is unknown.", encounteredId);
            return false;
        }
        if (encounteredId != expectedPacketHeader.getId()) {
            log.error("Encountered packet ID '{}' does not equal expected '{}'.", encounteredId, expectedPacketHeader.getId());
            return false;
        }
        return true;
    }

    private static boolean isSubIdValid(int encounteredSubId, PacketHeader expectedPacketHeader) throws PacketHeaderValidationFailedException {
        PacketSubType resolvedSubType = PacketSubType.of(encounteredSubId);
        if (resolvedSubType == null) {
            log.error("Encountered packet sub ID '{}' is unknown.", encounteredSubId);
            return false;
        }
        if (resolvedSubType != expectedPacketHeader.getPacketSubType()) {
            log.error("Encountered packet sub ID '{}' does not equal expected '{}'.", resolvedSubType, expectedPacketHeader.getPacketSubType());
            return false;
        }
        return true;
    }

    private static boolean isPacketSourceValid(int encounteredSource, PacketHeader expectedPacketHeader) throws PacketHeaderValidationFailedException {
        if (encounteredSource != 0x00 && encounteredSource != 0x34) {
            log.error("Encountered packet source '{}' is unknown.", encounteredSource);
            return false;
        }
        if (encounteredSource != expectedPacketHeader.getSource()) {
            log.error("Encountered packet source '{}' does not equal expected '{}'.", encounteredSource, expectedPacketHeader.getSource());
            return false;
        }
        return true;
    }

    public static PacketHeader parseQuick(BufferReader bufferReader) {
        int position = bufferReader.getPosition();

        int group = bufferReader.readUnsignedByte();
        int id = bufferReader.readUnsignedShort();
        int subId = bufferReader.readUnsignedByte();
        int source = bufferReader.readUnsignedByte();
        long count = bufferReader.readUnsignedInteger();

        bufferReader.setPosition(position);

        PacketHeader packetHeader = new PacketHeader(group, id, subId, source);
        packetHeader.setCount(count);

        return packetHeader;
    }

    protected PacketHeader parse(BufferReader bufferReader) throws PacketHeaderValidationFailedException {
        int group = bufferReader.readUnsignedByte();
        if (!isGroupValid(group, expectedPacketHeader)) {
            throw new PacketHeaderValidationFailedException();
        }

        int id = bufferReader.readUnsignedShort();
        if (!isIdValid(id, expectedPacketHeader)) {
            throw new PacketHeaderValidationFailedException();
        }

        int subId = bufferReader.readUnsignedByte();
        if (!isSubIdValid(subId, expectedPacketHeader)) {
            throw new PacketHeaderValidationFailedException();
        }

        int source = bufferReader.readUnsignedByte();
        if (!isPacketSourceValid(source, expectedPacketHeader)) {
            throw new PacketHeaderValidationFailedException();
        }

        long count = bufferReader.readUnsignedInteger();
        PacketHeader packetHeader = new PacketHeader(group, id, subId, source);
        packetHeader.setIdentifier(expectedPacketHeader.getIdentifier());
        packetHeader.setCount(count);

        log.debug("Parsed packet header: '{}'", packetHeader);

        return packetHeader;
    }
}
