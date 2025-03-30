package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.ui.uGUIAreaMaster;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class AreaMasterSpotData {
    private long SpotId;
    @MetaInformation
    private Translation SpotName;
    private long CategoryNo;
    @MetaInformation
    private Translation CategoryName;
    private long MessageId;
    @MetaInformation
    private Translation Message;
    private int StageNoMap;
    @MetaInformation
    private Translation StageName;
    @MetaInformation
    private long AreaId;
    @MetaInformation
    private Translation AreaName;
    private long QuestId;
    @MetaInformation
    private Translation QuestName;
    private float PosX;
    private float PosY;
    private float PosZ;
    private int ImageId;
    private int Rank;
    private int RecommendLevel;
    private int KeyType;
    private int MaskType;
    private boolean PosHide;
}
