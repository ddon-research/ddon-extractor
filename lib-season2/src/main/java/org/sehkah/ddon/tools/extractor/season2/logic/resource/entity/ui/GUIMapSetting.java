package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Rectangle;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector2f;
import org.sehkah.ddon.tools.extractor.api.entity.Resource;

import java.util.List;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class GUIMapSetting extends Resource {
    private Vector2f Center;
    private int FloorBaseId;
    private long FloorBaseSizeId;
    private long TextureNumX;
    private long TextureNumY;
    private Rectangle Rect;
    private float FoundationScale;
    private float OffsetPosX;
    private float OffsetPosY;
    private boolean UseIdTex;
    private List<GUIMapSettingData> Array;
}
