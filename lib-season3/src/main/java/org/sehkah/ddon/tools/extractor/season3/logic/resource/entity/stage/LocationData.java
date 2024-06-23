package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LocationDataType;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class LocationData {
    private Vector3f Pos;
    private float Radius;
    private float Angle;
    private float Range;
    private int MessageNo;
    private int Type;
    @MetaInformation
    private LocationDataType LocationType;
    private long WarpPointId;
    private boolean SafeZone;

    public LocationData(Vector3f pos, float radius, float angle, float range, int messageNo, int type, long warpPointId, boolean safeZone) {
        this(
                pos,
                radius,
                angle,
                range,
                messageNo,
                type, LocationDataType.of(type),
                warpPointId,
                safeZone);
    }
}
