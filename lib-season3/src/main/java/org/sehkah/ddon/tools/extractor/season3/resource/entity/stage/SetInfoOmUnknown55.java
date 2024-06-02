package org.sehkah.ddon.tools.extractor.season3.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmUnknown55 extends SetInfo {
    private final long Unknown1;
    private final long Unknown2;
    private final long Unknown3;
    private final long Unknown4;
    private final long Unknown5;
    private final long Unknown6;
    private final long Unknown7;
    private final long Unknown8;
    private final long Unknown9;
    private final boolean Unknown10;
    private final float Unknown11;
    private final boolean Unknown12;
    private final long Unknown13;
    private final int Unknown14;
    private final boolean IsQuest;
    private final long QuestId; // set to 0 when IsQuest is false
    private final long QuestFlag; // set to 0 when IsQuest is false
    private final SetInfoOmOld InfoOm;
}
