package org.sehkah.ddon.tools.extractor.season2.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class JobMasterCtrl {
    private long JobId;
    private long StartJobLevel;
    private long FirstTalkGrpSerial;
    private long TraningTalkGrpSerial;
    private long FirstOrderTalkGrpSerial;
    private long JobTutorialQuestId;
    private long JobMasterTutorialQuestId;
    private long AreaId;
    private long AreaRank;
}
