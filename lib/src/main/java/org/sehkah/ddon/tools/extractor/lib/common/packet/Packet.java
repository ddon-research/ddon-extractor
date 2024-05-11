package org.sehkah.ddon.tools.extractor.lib.common.packet;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class Packet {
    protected PacketHeader header;
    @MetaInformation
    protected int size;
    @MetaInformation
    protected int dataSize;
}
