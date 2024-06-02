package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Getter
@JsonPropertyOrder(alphabetic = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public final class FSMOrderParamBGMRequest extends AICopiableParameter {
    private final long BgmRequestType;
    private final long BgmRequestNo;
    private final long BgmRequestEditType;

    //TODO: season 3 exclusive
    private final boolean BgmRequestIsChangeFadeTime;
    private final long BgmRequestFadeTime;
}
