package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import java.math.BigInteger;

public record SetInfoOmCtrlLinkParam(
        int Kind,
        int Group,
        int ID,
        long Transition,
        long State,
        int CamEvNo,
        BigInteger FSMCamResID // rAIFSM
) {

}
