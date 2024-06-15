package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.datatype.Vector3f;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamSetEffect extends AICopiableParameter {
    private int EfcId;
    private int Target;
    private int Group;
    private int Id;
    private boolean HaveItem;
    private int Act;
    private int Type;
    private long OmId;
    private int Index;
    private int Element;
    private Vector3f Pos;
    private Vector3f Ang;
    private Vector3f Scl;
}
