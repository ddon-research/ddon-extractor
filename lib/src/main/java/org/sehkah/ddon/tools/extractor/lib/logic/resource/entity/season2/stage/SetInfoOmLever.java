package org.sehkah.ddon.tools.extractor.lib.logic.resource.entity.season2.stage;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;

@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
public class SetInfoOmLever extends SetInfo {
    private final boolean ReqLever;
    private final int CamEvNo;
    private final BigInteger FSMCamEvResId; // rAIFSM
    private final SetInfoOm InfoOm;
}