package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.math.BigInteger;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmCtrlLinkParam {
    private int Kind;
    private int Group;
    private int ID;
    private long Transition;
    private long State;
    private int CamEvNo;
    private BigInteger FSMCamResID; // rAIFSM;
}
