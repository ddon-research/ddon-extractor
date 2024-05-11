package org.sehkah.ddon.tools.extractor.lib.logic.packet;

import lombok.Data;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketDeserializer;

import java.lang.reflect.InvocationTargetException;

@Data
public class GamePacketFile {
    private PacketHeader packetHeader;
    private PacketDeserializer<Packet> deserializer;

    public GamePacketFile(PacketHeader packetHeader) {
        this(packetHeader, null, null);
    }

    public GamePacketFile(PacketHeader packetHeader, Class<?> deserializerClass) {
        this(packetHeader, deserializerClass, null);
    }

    public GamePacketFile(PacketHeader packetHeader, Class<?> deserializerClass, Class<?> serializerClass) {
        try {
            this.packetHeader = packetHeader;
            if (deserializerClass != null) {
                this.deserializer = (PacketDeserializer<Packet>) deserializerClass.getConstructor(GamePacketFile.class).newInstance(this);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new TechnicalException(e);
        }
    }
}
