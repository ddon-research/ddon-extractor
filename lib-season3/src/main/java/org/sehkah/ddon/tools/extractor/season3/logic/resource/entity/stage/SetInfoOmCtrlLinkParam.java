package org.sehkah.ddon.tools.extractor.season3.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LayoutUnitKind;

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
    @MetaInformation
    private LayoutUnitKind KindType;
    private int Group;
    private int ID;
    private long Transition;
    private long State;
    private int CamEvNo;
    private BigInteger FSMCamResID;//rAISFM

    public SetInfoOmCtrlLinkParam(int kind, int group, int ID, long transition, long state, int camEvNo, BigInteger FSMCamResID) {
        this(
                kind, LayoutUnitKind.of(kind),
                group,
                ID,
                transition,
                state,
                camEvNo,
                FSMCamResID
        );
    }
}
