package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.sehkah.ddon.tools.extractor.lib.common.datatype.Vector3f;

@RequiredArgsConstructor
@Getter
public class SetInfoOmDoor extends SetInfo {
    private final boolean PRT;
    private final Vector3f PRTPos;
    private final float PRTScale;
    private final long TextType;
    private final long TextQuestNo;
    private final long TextNo;
    private final long QuestID;
    private final long QuestFlag;
    private final SetInfoOm InfoOm;
}
