package org.sehkah.ddon.tools.extractor.api.logic.packet.deserialization;

import org.sehkah.ddon.tools.extractor.api.io.BufferReader;
import org.sehkah.ddon.tools.extractor.api.packet.Packet;

public interface PacketBufferDeserializer<T extends Packet> {
    T deserialize(BufferReader bufferReader);
}
