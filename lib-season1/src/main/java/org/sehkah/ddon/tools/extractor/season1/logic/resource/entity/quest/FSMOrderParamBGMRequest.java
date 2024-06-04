package org.sehkah.ddon.tools.extractor.season1.logic.resource.entity.quest;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSMOrderParamBGMRequest extends AICopiableParameter {
    private long BgmRequestType;
    private long BgmRequestNo;
    private long BgmRequestEditType;

    //TODO: season 3 exclusive
    private boolean BgmRequestIsChangeFadeTime;
    private long BgmRequestFadeTime;
}
