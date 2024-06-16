package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaMasterSpotData {
    // TODO: Lookup
    private long SpotId;
    private long CategoryNo;
    // TODO: Lookup -> am_spot_01.ams.json => area1_spot_info.gmd.json
    private long MessageId;
    private int StageNoMap;
    private float PosX;
    private float PosY;
    private float PosZ;
    private int ImageId;
    private int RecommendLevel;
    private int KeyType;
    private int MaskType;
    private boolean PosHide;
}
