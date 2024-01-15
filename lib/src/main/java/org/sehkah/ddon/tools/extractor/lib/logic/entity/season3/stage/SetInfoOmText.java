package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmText extends SetInfo {
    private final long TextNo;
    private final long TextQuestNo;
    private final long TextType;
    private final SetInfoOm InfoOm;
}
