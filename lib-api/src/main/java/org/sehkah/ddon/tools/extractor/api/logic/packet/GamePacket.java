package org.sehkah.ddon.tools.extractor.api.logic.packet;

import lombok.Data;
import org.sehkah.ddon.tools.extractor.api.error.TechnicalException;
import org.sehkah.ddon.tools.extractor.api.logic.packet.deserialization.PacketBufferDeserializer;
import org.sehkah.ddon.tools.extractor.api.logic.packet.serialization.PacketSerializer;
import org.sehkah.ddon.tools.extractor.api.packet.Packet;
import org.sehkah.ddon.tools.extractor.api.packet.PacketHeader;

import java.lang.reflect.InvocationTargetException;

@Data
public class GamePacket {
    private PacketHeader packetHeader;
    private PacketBufferDeserializer<Packet> deserializer;
    private PacketSerializer<Packet> serializer;

    public GamePacket(PacketHeader packetHeader, Class<?> deserializerClass) {
        this(packetHeader, deserializerClass, null);
    }

    public GamePacket(PacketHeader packetHeader, Class<?> deserializerClass, Class<?> serializerClass) {
        try {
            this.packetHeader = packetHeader;
            if (deserializerClass != null) {
                this.deserializer = (PacketBufferDeserializer<Packet>) deserializerClass.getConstructor(GamePacket.class).newInstance(this);
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
