package org.sehkah.ddon.tools.extractor.api.packet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public abstract class Packet {
    protected PacketHeader header;
    @MetaInformation
    protected int size;
    @MetaInformation
    protected int dataSize;
}
