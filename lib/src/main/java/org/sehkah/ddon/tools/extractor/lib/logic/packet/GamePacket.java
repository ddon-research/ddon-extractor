package org.sehkah.ddon.tools.extractor.lib.logic.packet;

import lombok.Data;
import org.sehkah.ddon.tools.extractor.lib.common.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.packet.PacketHeader;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization.PacketDeserializer;
import org.sehkah.ddon.tools.extractor.lib.logic.packet.serialization.PacketSerializer;

import java.lang.reflect.InvocationTargetException;

@Data
public class GamePacket {
    private PacketHeader packetHeader;
    private PacketDeserializer<Packet> deserializer;
    private PacketSerializer<Packet> serializer;

    public GamePacket(PacketHeader packetHeader, Class<?> deserializerClass) {
        this(packetHeader, deserializerClass, null);
    }

    public GamePacket(PacketHeader packetHeader, Class<?> deserializerClass, Class<?> serializerClass) {
        try {
            this.packetHeader = packetHeader;
            if (deserializerClass != null) {
                this.deserializer = (PacketDeserializer<Packet>) deserializerClass.getConstructor(GamePacket.class).newInstance(this);
            }
            if (serializerClass != null) {
                this.serializer = (PacketSerializer<Packet>) serializerClass.getConstructor(GamePacket.class).newInstance(this);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new TechnicalException(e);
        }
    }
}
