package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.stage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.math.BigInteger;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class SetInfoOmLever extends SetInfo {
    private boolean ReqLever;
    private int CamEvNo;
    private BigInteger FSMCamEvResId; // rAIFSM
    private SetInfoOm InfoOm;
}
