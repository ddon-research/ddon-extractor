package org.sehkah.ddon.tools.extractor.lib.logic.packet.serialization;


import org.sehkah.ddon.tools.extractor.lib.common.error.SerializerException;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;

public interface PacketSerializer<T extends Packet> {
    byte[] serialize(T deserialized) throws SerializerException;
}
