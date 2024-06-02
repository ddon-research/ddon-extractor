package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Sphere;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class ZoneShapeInfoSphere extends ZoneShapeInfoBase {
    private final Sphere Sphere;

    public ZoneShapeInfoSphere(ZoneShapeInfoBase base, org.sehkah.ddon.tools.extractor.lib.common.datatype.Sphere sphere) {
        super(base.getDecay());
        Sphere = sphere;
    }
}
