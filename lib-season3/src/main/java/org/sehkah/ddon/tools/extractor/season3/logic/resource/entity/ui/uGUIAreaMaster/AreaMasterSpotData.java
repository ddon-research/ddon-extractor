package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster;

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
    // TODO: Lookup
    private long MessageId;
    // TODO: Lookup
    private int StageNoMap;
    // TODO: Lookup
    private long QuestId;
    private float PosX;
    private float PosY;
    private float PosZ;
    private int ImageId;
    private int UnknownByte;
    private int RecommendLevel;
    private int KeyType;
    private int MaskType;
    private boolean PosHide;
}
