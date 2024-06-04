package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.MyRoom;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class PartnerPawnTalkInfo {
    private List<PartnerPawnTalkInfoData> TalkList;
}
