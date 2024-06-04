package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.EM;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class EmLvUpParam {
    private long Lv;
    private List<Float> Hp_Cor;
    private List<Float> ShP_Cor;
    private List<Float> BlP_Cor;
    private float Ocd_Cor;
    private float AttackWepPhys_Cor;
    private float AttackWepMagic_Cor;
    private float DefenceWepPhys_Cor;
    private float DefenceWepMagic_Cor;
    private float AttackBasePhys_Cor;
    private float AttackBaseMagic_Cor;
    private float DefenceBasePhys_Cor;
    private float DefenceBaseMagic_Cor;
    private float Power_Cor;
    private float GuardDefBase_Cor;
    private float GuardDefWep_Cor;
    private float DownP_Cor;
    private float ShakeP_Cor;
}
