package org.sehkah.ddon.tools.extractor.common.logic.resource.entity.game_common;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.sehkah.ddon.tools.extractor.api.logic.resource.Translation;
import org.sehkah.ddon.tools.extractor.api.serialization.MetaInformation;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class JobMasterCtrl {
    private long JobId;
    @MetaInformation
    private Translation JobName;
    private long StartJobLevel;
    // TODO: lookup
    private long FirstTalkGrpSerial;
    private long TraningTalkGrpSerial;
    private long FirstOrderTalkGrpSerial;
    private long JobTutorialQuestId;
    @MetaInformation
    private Translation JobTutorialQuestName;
    private long JobMasterTutorialQuestId;
    @MetaInformation
    private Translation JobMasterTutorialQuestName;
    private long AreaId;
    @MetaInformation
    private Translation AreaName;
    private long AreaRank;
}
