package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.ui.uGUIAreaMaster;

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
    private long SpotId;
    private long CategoryNo;
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
