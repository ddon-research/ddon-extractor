package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamCamera extends AICopiableParameter {
    private int ActType;//Camera:ActType
    private int CamRes;//Camera:CamRes
    private boolean IsBtlNoCancel;//season 3 exclusive
    private int CamId1;
    private int CamId2;
    private int CameraEnemyActType;//CameraEnemy:ActType
    private boolean CantActPl;
    private int CamId3;
}
