package org.sehkah.ddon.tools.extractor.season3.packet.entity.l2c;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class L2CLoginRes extends Packet {
    private final long Error;
    private final long Result;
    private final String OnetimeToken;
}
