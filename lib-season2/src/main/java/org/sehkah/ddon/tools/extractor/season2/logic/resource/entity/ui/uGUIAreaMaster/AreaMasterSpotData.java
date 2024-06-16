package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.ui.uGUIAreaMaster;

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
    // TODO: Lookup -> am_spot_01.ams.json => area1_spot_info.gmd.json
    private long MessageId;
    private int StageNoMap;
    @MetaInformation
    private Translation StageName;
    private float PosX;
    private float PosY;
    private float PosZ;
    private int ImageId;
    private int RecommendLevel;
    private int KeyType;
    private int MaskType;
    private boolean PosHide;
}
