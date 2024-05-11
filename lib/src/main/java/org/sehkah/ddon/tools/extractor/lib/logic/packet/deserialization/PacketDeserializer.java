package org.sehkah.ddon.tools.extractor.lib.logic.packet.deserialization;

import org.sehkah.ddon.tools.extractor.lib.common.io.FileReader;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;

public interface PacketDeserializer<T extends Packet> {
    T deserialize(FileReader fileReader);
}
