package org.sehkah.ddon.tools.extractor.lib.logic.entity.season3.stage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
@Getter
public class SetInfoOmLever extends SetInfo {
    private final boolean ReqLever;
    private final int CamEvNo;
    private final BigInteger FSMCamEvResId; // rAIFSM
    private final SetInfoOm InfoOm;
}
