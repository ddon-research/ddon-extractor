package org.sehkah.ddon.tools.extractor.lib.logic.packet.entity.c2s;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class C2SClanGetMyInfoReq extends Packet {
    public C2SClanGetMyInfoReq() {
    }
}