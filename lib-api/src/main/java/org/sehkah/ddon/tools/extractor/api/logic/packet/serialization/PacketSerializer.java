package org.sehkah.ddon.tools.extractor.api.logic.packet.serialization;


import org.sehkah.ddon.tools.extractor.api.error.SerializerException;
import org.sehkah.ddon.tools.extractor.api.packet.Packet;

public interface PacketSerializer<T extends Packet> {
    byte[] serialize(T deserialized) throws SerializerException;
}
