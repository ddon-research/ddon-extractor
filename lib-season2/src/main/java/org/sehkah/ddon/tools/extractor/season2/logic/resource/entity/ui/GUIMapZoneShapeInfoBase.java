package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIMapZoneShapeInfoBase {
    private float Decay;
    private boolean IsNativeData;
}
