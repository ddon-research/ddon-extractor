package org.sehkah.ddon.tools.extractor.lib.common.packet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class Packet {
    protected PacketHeader header;
    protected int size;
}
