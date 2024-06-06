package org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2s;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.api.packet.Packet;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class C2SClanGetMyInfoReq extends Packet {
    public C2SClanGetMyInfoReq() {
    }
}
