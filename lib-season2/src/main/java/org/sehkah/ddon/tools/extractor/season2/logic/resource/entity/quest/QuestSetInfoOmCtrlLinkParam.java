package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;
import org.sehkah.ddon.tools.extractor.common.logic.resource.entity.stage.meta.LayoutUnitKind;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class QuestSetInfoOmCtrlLinkParam {
    private int Kind;
    @MetaInformation
    private LayoutUnitKind KindType;
    private int Group;
    private int ID;
    private long Transition;
    private long State;
    private int CamEvNo;
    private String FSM; // rAIFSM;

    public QuestSetInfoOmCtrlLinkParam(int kind, int group, int ID, long transition, long state, int camEvNo, String FSM) {
        this(
                kind, LayoutUnitKind.of(kind),
                group,
                ID,
                transition,
                state,
                camEvNo,
                FSM
        );
    }
}
