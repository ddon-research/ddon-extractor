package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.io.BufferReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;

public interface PacketBufferDeserializer<T extends Packet> {
    T deserialize(BufferReader bufferReader);
}
