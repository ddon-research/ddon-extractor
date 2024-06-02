package org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.packet.Packet;
import org.sehkah.ddon.tools.extractor.lib.common.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.season3.logic.packet.entity.c2l.meta.PlatformType;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class C2LLoginReq extends Packet {
    public final String oneTimeToken;
    public final int platform;
    @MetaInformation
    public final PlatformType platformTypeName;

    public C2LLoginReq(String oneTimeToken, int platform) {
        this.oneTimeToken = oneTimeToken;
        this.platform = platform;
        this.platformTypeName = PlatformType.of(platform);
    }
}
