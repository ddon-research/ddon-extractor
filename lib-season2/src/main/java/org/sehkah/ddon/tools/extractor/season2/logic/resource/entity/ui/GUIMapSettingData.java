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
public class GUIMapSettingData {
    private int ShapeType;
    private String ShapeName;
    private GUIMapAreaHitShape Shape;
    private long FloorId;
}
