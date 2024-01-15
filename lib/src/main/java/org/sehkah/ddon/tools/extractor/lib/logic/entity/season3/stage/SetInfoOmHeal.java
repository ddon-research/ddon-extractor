package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SetInfoOmHeal extends SetInfo {
    private final long HealType;
    private final SetInfoOm InfoOm;
}
