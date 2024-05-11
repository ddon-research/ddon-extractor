package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

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
