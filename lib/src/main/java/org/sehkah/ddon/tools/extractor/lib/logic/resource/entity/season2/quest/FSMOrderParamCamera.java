package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMOrderParamCamera extends AICopiableParameter {
    private final int ActType;//Camera:ActType
    private final int CamRes;//Camera:CamRes
    private final boolean IsBtlNoCancel;//season 3 exclusive
    private final int CamId1;
    private final int CamId2;
    private final int CameraEnemyActType;//CameraEnemy:ActType
    private final boolean CantActPl;
    private final int CamId3;
}
